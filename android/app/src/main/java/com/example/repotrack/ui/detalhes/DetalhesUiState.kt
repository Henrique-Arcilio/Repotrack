package com.example.repotrack.ui.detalhes

import com.example.repotrack.data.model.RepositorioModel

data class DetalhesUiState(
    val carregando: Boolean = false,
    val repositorio: RepositorioModel? = null,
    val erro: String? = null
)
