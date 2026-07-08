package com.example.repotrack.ui.detalhes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetalhesScreen(
    proprietario: String,
    nome: String,
    onVoltar: () -> Unit,
    onAbrirRepositorio: (String) -> Unit,
    viewModel: DetalhesViewModel = viewModel()
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.erro) {
        uiState.erro?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.consumirMensagemErro()
        }
    }

    LaunchedEffect(uiState.mensagemSucesso) {
        uiState.mensagemSucesso?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.consumirMensagemSucesso()
        }
    }

    LaunchedEffect(proprietario, nome) {
        viewModel.buscarRepositorio(
            proprietario = proprietario,
            nome = nome
        )
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                uiState.carregando -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                uiState.repositorio != null -> {
                    val repositorio = uiState.repositorio!!

                    DetalhesContent(
                        repositorio = repositorio,
                        prioridade = uiState.prioridade,
                        status = uiState.status,
                        observacoes = uiState.observacoes,
                        onVoltar = onVoltar,
                        onAdicionarProjeto = {
                            viewModel.salvarRepositorio()
                        },
                        onAbrirRepositorio = {
                            onAbrirRepositorio(
                                repositorio.repositorioUrl
                            )
                        },
                        onPrioridadeAlterada = viewModel::atualizarPrioridade,
                        onStatusAlterado = viewModel::atualizarStatus,
                        onObservacoesAlteradas = viewModel::atualizarObservacoes
                    )
                }
            }
        }
    }
}