package com.example.repotrack.ui.busca

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.repository.GitHubRepository
import kotlinx.coroutines.launch

class PesquisaViewModel (
    private val repository: GitHubRepository = GitHubRepository()
) : ViewModel() {
    var termo by mutableStateOf("")
        private set
    var repositorios by mutableStateOf<List<RepositorioGithubModel>>(emptyList())
        private set
    var carregando by mutableStateOf(false)
        private set
    var mensagemErro by mutableStateOf<String?>(null)
        private set
    fun alterarTermo(novoTermo: String) {
        termo = novoTermo
    }

    fun pesquisar() {
        if (termo.isBlank()) return
        viewModelScope.launch {
            carregando = true
            mensagemErro = null
            try {
                repositorios = repository.pesquisar(termo)
            } catch (erro: Exception) {
                repositorios = emptyList()
                mensagemErro = "Nao foi possivel buscar os repositorios."
            } finally {
                carregando = false
            }
        }
    }
}