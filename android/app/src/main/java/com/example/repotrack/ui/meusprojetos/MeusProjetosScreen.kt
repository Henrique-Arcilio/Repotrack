package com.example.repotrack.ui.meusprojetos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.repotrack.ui.components.CardProjetoSalvo
import com.example.repotrack.ui.components.CampoObservacao
import com.example.repotrack.ui.components.ResumoRepositorioSelecionado
import com.example.repotrack.ui.components.SeletorOpcoes
import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeusProjetosScreen(
    viewModel: MeusProjetosViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Meus Projetos") })
        }
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
                uiState.erro != null -> {
                    Text(
                        text = uiState.erro!!,
                        modifier = Modifier.align(Alignment.Center),
                        color = androidx.compose.ui.graphics.Color.Red
                    )
                }
                uiState.projetos.isEmpty() -> {
                    Text(
                        text = "Nenhum projeto salvo ainda.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
                    ) {
                        items(uiState.projetos) { projeto ->
                            CardProjetoSalvo(
                                projeto = projeto,
                                onEditarClick = { 
                                    viewModel.iniciarEdicao(projeto)
                                },
                                onDeletarClick = {
                                    viewModel.deletarProjeto(projeto.id)
                                }
                            )
                        }
                    }
                }
            }
        }

        // Modal de Edição
        if (uiState.projetoSendoEditado != null) {
            val projeto = uiState.projetoSendoEditado!!
            
            ModalBottomSheet(
                onDismissRequest = { viewModel.cancelarEdicao() },
                sheetState = sheetState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Editar projeto",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(onClick = { viewModel.cancelarEdicao() }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Fechar")
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    ResumoRepositorioSelecionado(
                        repositorio = RepositorioGithubModel(
                            githubId = projeto.githubId,
                            nome = projeto.nome,
                            proprietario = projeto.proprietario,
                            descricao = projeto.descricao,
                            linguagem = projeto.linguagem,
                            avatarUrl = projeto.avatarUrl,
                            repositorioUrl = projeto.repositorioUrl,
                            estrelas = projeto.estrelas,
                            forks = projeto.forks
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    SeletorOpcoes(
                        titulo = "Status",
                        opcoes = Status.entries.map { 
                            it.name.replace("_", " ").lowercase().replaceFirstChar { char -> char.uppercase() } 
                        },
                        opcaoSelecionada = uiState.statusEdicao.name.replace("_", " ").lowercase().replaceFirstChar { char -> char.uppercase() },
                        onOpcaoSelecionada = { nome ->
                            val entry = Status.entries.find { it.name.replace("_", " ").equals(nome, ignoreCase = true) }
                            if (entry != null) viewModel.atualizarStatus(entry)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SeletorOpcoes(
                        titulo = "Prioridade",
                        opcoes = Priority.entries.map { it.name.lowercase().replaceFirstChar { char -> char.uppercase() } },
                        opcaoSelecionada = uiState.prioridadeEdicao.name.lowercase().replaceFirstChar { char -> char.uppercase() },
                        onOpcaoSelecionada = { nome ->
                            val entry = Priority.entries.find { it.name.equals(nome, ignoreCase = true) }
                            if (entry != null) viewModel.atualizarPrioridade(entry)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Observação", style = MaterialTheme.typography.labelLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    CampoObservacao(
                        valor = uiState.observacoesEdicao,
                        onValorChange = { viewModel.atualizarObservacoes(it) }
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Button(
                        onClick = { viewModel.salvarEdicao() },
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = "Salvar Alterações")
                    }
                }
            }
        }
    }
}