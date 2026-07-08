package com.example.repotrack.ui.meusprojetos

import com.example.repotrack.data.model.RepositorioRepotrackModel

data class MeusProjetosUiState(
    val carregando: Boolean = false,
    val projetos: List<RepositorioRepotrackModel> = emptyList(),
    val erro: String? = null
)