package com.example.repotrack.ui.detalhes

import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

data class DetalhesUiState(
    val carregando: Boolean = false,
    val repositorio: RepositorioGithubModel? = null,
    val erro: String? = null,
    
    val prioridade: Priority = Priority.MEDIA,
    val status: Status = Status.QUERO_ESTUDAR,
    val observacoes: String = ""
)
