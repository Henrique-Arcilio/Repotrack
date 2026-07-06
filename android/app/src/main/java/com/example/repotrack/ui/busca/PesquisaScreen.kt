package com.example.repotrack.ui.busca

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

// essa classe controla o estado da navegação
@Composable
fun PesquisaScreen(
    onRepositorioClick: (String, String) -> Unit,
    viewModel: PesquisaViewModel = viewModel()
) {
    PesquisaContent(
        termo = viewModel.termo,
        repositorios = viewModel.repositorios,
        carregando = viewModel.carregando,
        onTermoChange = viewModel::alterarTermo,
        onPesquisar = viewModel::pesquisar,
        onRepositorioClick = onRepositorioClick
    )
}