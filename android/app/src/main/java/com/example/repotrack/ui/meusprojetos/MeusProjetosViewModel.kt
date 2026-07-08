package com.example.repotrack.ui.meusprojetos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repotrack.data.model.RepositorioRepotrackModel
import com.example.repotrack.data.remote.dto.RepotrackSaveDto
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status
import com.example.repotrack.data.repository.RepotrackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MeusProjetosViewModel : ViewModel() {

    private val repository = RepotrackRepository()
    private val _uiState = MutableStateFlow(MeusProjetosUiState())
    val uiState: StateFlow<MeusProjetosUiState> = _uiState.asStateFlow()

    init {
        carregarProjetos()
    }

    fun carregarProjetos() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(carregando = true, erro = null)
            try {
                val projetos = repository.buscarTodos()
                _uiState.value = _uiState.value.copy(
                    carregando = false,
                    projetos = projetos
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    carregando = false,
                    erro = e.message ?: "Erro ao carregar projetos"
                )
            }
        }
    }

    fun deletarProjeto(id: String) {
        viewModelScope.launch {
            try {
                repository.deletarPorId(id)
                carregarProjetos()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    erro = e.message ?: "Erro ao deletar projeto"
                )
            }
        }
    }

    fun iniciarEdicao(projeto: RepositorioRepotrackModel) {
        _uiState.value = _uiState.value.copy(
            projetoSendoEditado = projeto,
            prioridadeEdicao = projeto.prioridade,
            statusEdicao = projeto.status,
            observacoesEdicao = projeto.observacoes
        )
    }

    fun cancelarEdicao() {
        _uiState.value = _uiState.value.copy(projetoSendoEditado = null)
    }

    fun atualizarPrioridade(prioridade: Priority) {
        _uiState.value = _uiState.value.copy(prioridadeEdicao = prioridade)
    }

    fun atualizarStatus(status: Status) {
        _uiState.value = _uiState.value.copy(statusEdicao = status)
    }

    fun atualizarObservacoes(observacoes: String) {
        _uiState.value = _uiState.value.copy(observacoesEdicao = observacoes)
    }

    fun salvarEdicao() {
        val state = _uiState.value
        val projeto = state.projetoSendoEditado ?: return

        viewModelScope.launch {
            try {
                val dto = RepotrackSaveDto(
                    githubId = projeto.githubId,
                    name = projeto.nome,
                    fullName = projeto.proprietario,
                    description = projeto.descricao ?: "",
                    language = projeto.linguagem ?: "",
                    avatarUrl = projeto.avatarUrl ?: "",
                    repositoryUrl = projeto.repositorioUrl,
                    stars = projeto.estrelas,
                    forks = projeto.forks,
                    priority = state.prioridadeEdicao,
                    status = state.statusEdicao,
                    notes = state.observacoesEdicao
                )
                repository.editar(projeto.id, dto)
                _uiState.value = _uiState.value.copy(projetoSendoEditado = null)
                carregarProjetos()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    erro = e.message ?: "Erro ao editar projeto"
                )
            }
        }
    }
}