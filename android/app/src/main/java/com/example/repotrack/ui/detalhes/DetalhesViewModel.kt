package com.example.repotrack.ui.detalhes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repotrack.data.repository.GitHubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetalhesViewModel : ViewModel() {

    private val repository = GitHubRepository()

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
                    repository.buscarDetalhes(
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
}