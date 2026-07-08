package com.example.repotrack.ui.meusprojetos

import com.example.repotrack.data.model.RepositorioRepotrackModel
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

data class MeusProjetosUiState(
    val carregando: Boolean = false,
    val projetos: List<RepositorioRepotrackModel> = emptyList(),
    val erro: String? = null,
    

    val projetoSendoEditado: RepositorioRepotrackModel? = null,
    val prioridadeEdicao: Priority = Priority.MEDIA,
    val statusEdicao: Status = Status.QUERO_ESTUDAR,
    val observacoesEdicao: String = ""
)