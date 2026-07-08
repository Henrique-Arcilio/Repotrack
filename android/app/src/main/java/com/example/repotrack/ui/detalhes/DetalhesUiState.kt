package com.example.repotrack.ui.detalhes

import com.example.repotrack.data.model.RepositorioGithubModel

data class DetalhesUiState(
    val carregando: Boolean = false,
    val repositorio: RepositorioGithubModel? = null,
    val erro: String? = null
)
