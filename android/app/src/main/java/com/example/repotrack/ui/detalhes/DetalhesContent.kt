package com.example.repotrack.ui.detalhes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.ui.components.BotaoAdicionarProjeto
import com.example.repotrack.ui.components.CabecalhoDetalhes
import com.example.repotrack.ui.components.CardMetrica
import com.example.repotrack.ui.components.LinkRepositorio
import com.example.repotrack.ui.components.SeletorOpcoes
import com.example.repotrack.ui.components.TopoDetalhes
import com.example.repotrack.ui.components.CampoObservacao
import com.example.repotrack.ui.components.ResumoRepositorioSelecionado
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesContent(
    repositorio: RepositorioGithubModel,
    prioridade: Priority,
    status: Status,
    observacoes: String,
    onVoltar: () -> Unit,
    onAdicionarProjeto: () -> Unit,
    onAbrirRepositorio: () -> Unit,
    onPrioridadeAlterada: (Priority) -> Unit,
    onStatusAlterado: (Status) -> Unit,
    onObservacoesAlteradas: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var mostrarSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopoDetalhes(onVoltar = onVoltar)
        }
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            CabecalhoDetalhes(
                nome = repositorio.nome,
                proprietario = repositorio.proprietario,
                avatarUrl = repositorio.avatarUrl,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = repositorio.descricao
                    ?: "Sem descrição disponível.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CardMetrica(
                    valor = formatarNumero(repositorio.estrelas),
                    legenda = "Estrelas",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFF59E0B),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )

                CardMetrica(
                    valor = formatarNumero(repositorio.forks),
                    legenda = "Forks",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )

                CardMetrica(
                    valor = repositorio.linguagem ?: "Não informada",
                    legenda = "Linguagem",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            LinkRepositorio(
                url = repositorio.repositorioUrl,
                onClick = onAbrirRepositorio
            )

            Spacer(modifier = Modifier.height(22.dp))

            BotaoAdicionarProjeto(
                onClick = { mostrarSheet = true }
            )
        }

        if (mostrarSheet) {
            ModalBottomSheet(
                onDismissRequest = { mostrarSheet = false },
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.surface
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
                            text = "Adicionar projeto",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(onClick = { mostrarSheet = false }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Fechar"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    ResumoRepositorioSelecionado(
                        repositorio = repositorio
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    SeletorOpcoes(
                        titulo = "Status",
                        opcoes = Status.entries.map { 
                            it.name.replace("_", " ")
                                .lowercase()
                                .replaceFirstChar { char -> char.uppercase() } 
                        },
                        opcaoSelecionada = status.name.replace("_", " ")
                            .lowercase()
                            .replaceFirstChar { char -> char.uppercase() },
                        onOpcaoSelecionada = { nome ->
                            val entry = Status.entries.find { 
                                it.name.replace("_", " ").equals(nome, ignoreCase = true) 
                            }
                            if (entry != null) onStatusAlterado(entry)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SeletorOpcoes(
                        titulo = "Prioridade",
                        opcoes = Priority.entries.map { 
                            it.name.lowercase().replaceFirstChar { char -> char.uppercase() } 
                        },
                        opcaoSelecionada = prioridade.name.lowercase()
                            .replaceFirstChar { char -> char.uppercase() },
                        onOpcaoSelecionada = { nome ->
                            val entry = Priority.entries.find { 
                                it.name.equals(nome, ignoreCase = true) 
                            }
                            if (entry != null) onPrioridadeAlterada(entry)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Observação",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                    CampoObservacao(
                        valor = observacoes,
                        onValorChange = onObservacoesAlteradas
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Button(
                        onClick = {
                            onAdicionarProjeto()
                            mostrarSheet = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(text = "Salvar")
                    }
                }
            }
        }
    }
}

private fun formatarNumero(numero: Int): String {
    return when {
        numero >= 1_000_000 -> {
            String.format(
                Locale.US,
                "%.1fM",
                numero / 1_000_000.0
            )
        }

        numero >= 1_000 -> {
            String.format(
                Locale.US,
                "%.1fk",
                numero / 1_000.0
            )
        }

        else -> numero.toString()
    }
}