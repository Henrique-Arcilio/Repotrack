package com.example.repotrack.ui.detalhes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetalhesScreen(
    proprietario: String,
    nome: String,
    onVoltar: () -> Unit,
    onAdicionarProjeto: () -> Unit,
    onAbrirRepositorio: (String) -> Unit,
    viewModel: DetalhesViewModel = viewModel()
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(proprietario, nome) {
        viewModel.buscarRepositorio(
            proprietario = proprietario,
            nome = nome
        )
    }

    when {
        uiState.carregando -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        uiState.erro != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = uiState.erro
                        ?: "Erro desconhecido"
                )
            }
        }

        uiState.repositorio != null -> {
            val repositorio = uiState.repositorio!!

            DetalhesContent(
                repositorio = repositorio,
                onVoltar = onVoltar,
                onAdicionarProjeto = onAdicionarProjeto,
                onAbrirRepositorio = {
                    onAbrirRepositorio(
                        repositorio.repositorioUrl
                    )
                }
            )
        }
    }
}