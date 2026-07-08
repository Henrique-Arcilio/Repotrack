package com.example.repotrack.ui.detalhes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repotrack.data.repository.GitHubRepository
import com.example.repotrack.data.repository.RepotrackRepository
import com.example.repotrack.data.remote.mappers.toSaveDto
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetalhesViewModel : ViewModel() {

    private val gitHubRepository = GitHubRepository()
    private val repotrackRepository = RepotrackRepository()
    private val _uiState =
        MutableStateFlow(DetalhesUiState())

    val uiState: StateFlow<DetalhesUiState> =
        _uiState.asStateFlow()

    fun buscarRepositorio(
        proprietario: String,
        nome: String
    ) {
        viewModelScope.launch {
            _uiState.value = DetalhesUiState(
                carregando = true
            )

            try {
                val repositorio =
                    gitHubRepository.buscarDetalhes(
                        proprietario = proprietario,
                        nome = nome
                    )

                _uiState.value = DetalhesUiState(
                    repositorio = repositorio
                )
            } catch (erro: Exception) {
                _uiState.value = DetalhesUiState(
                    erro = erro.message
                        ?: "Erro ao carregar repositório"
                )
            }
        }
    }
    
    fun salvarRepositorio() {
        val state = _uiState.value
        val repositorio = state.repositorio ?: return

        viewModelScope.launch {
            try {
                val dto = repositorio.toSaveDto(
                    prioridade = state.prioridade,
                    status = state.status,
                    observacoes = state.observacoes
                )
                repotrackRepository.salvar(dto)
                _uiState.value = _uiState.value.copy(
                    mensagemSucesso = "Repositório salvo com sucesso!",
                    erro = null
                )
            } catch (erro: HttpException) {
                val mensagem = if (erro.code() == 409) {
                    "Este repositório já está salvo na sua lista."
                } else {
                    "Erro no servidor: ${erro.code()}"
                }
                _uiState.value = _uiState.value.copy(erro = mensagem)
            } catch (erro: Exception) {
                _uiState.value = _uiState.value.copy(
                    erro = erro.message ?: "Erro ao salvar repositório"
                )
            }
        }
    }

    fun atualizarPrioridade(novaPrioridade: Priority) {
        _uiState.value = _uiState.value.copy(prioridade = novaPrioridade)
    }

    fun atualizarStatus(novoStatus: Status) {
        _uiState.value = _uiState.value.copy(status = novoStatus)
    }

    fun atualizarObservacoes(novasObservacoes: String) {
        _uiState.value = _uiState.value.copy(observacoes = novasObservacoes)
    }

    fun consumirMensagemErro() {
        _uiState.value = _uiState.value.copy(erro = null)
    }

    fun consumirMensagemSucesso() {
        _uiState.value = _uiState.value.copy(mensagemSucesso = null)
    }
}