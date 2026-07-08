package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun AdicionarProjetoDialog(
    repositorio: RepositorioGithubModel,
    prioridade: String,
    status: String,
    observacao: String,
    onPrioridadeChange: (String) -> Unit,
    onStatusChange: (String) -> Unit,
    onObservacaoChange: (String) -> Unit,
    onSalvar: () -> Unit,
    onFechar: () -> Unit
) {
    Dialog(
        onDismissRequest = onFechar
    ) {
        AdicionarProjetoContent(
            repositorio = repositorio,
            prioridade = prioridade,
            status = status,
            observacao = observacao,
            onPrioridadeChange = onPrioridadeChange,
            onStatusChange = onStatusChange,
            onObservacaoChange = onObservacaoChange,
            onSalvar = onSalvar,
            onFechar = onFechar
        )
    }
}

@Composable
fun AdicionarProjetoContent(
    repositorio: RepositorioGithubModel,
    prioridade: String,
    status: String,
    observacao: String,
    onPrioridadeChange: (String) -> Unit,
    onStatusChange: (String) -> Unit,
    onObservacaoChange: (String) -> Unit,
    onSalvar: () -> Unit,
    onFechar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .widthIn(max = 390.dp),
        shape = RoundedCornerShape(22.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
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

                IconButton(
                    onClick = onFechar
                ) {
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

            Spacer(modifier = Modifier.height(20.dp))

            SeletorOpcoes(
                titulo = "Prioridade",
                opcoes = listOf("Baixa", "Média", "Alta"),
                opcaoSelecionada = prioridade,
                onOpcaoSelecionada = onPrioridadeChange
            )

            Spacer(modifier = Modifier.height(18.dp))

            SeletorOpcoes(
                titulo = "Status",
                opcoes = listOf("Quero estudar", "Estudando", "Concluído"),
                opcaoSelecionada = status,
                onOpcaoSelecionada = onStatusChange
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Observação",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            CampoObservacao(
                valor = observacao,
                onValorChange = onObservacaoChange
            )

            Spacer(modifier = Modifier.height(26.dp))

            Button(
                onClick = onSalvar,
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

@Preview(
    showBackground = true,
    widthDp = 430,
    heightDp = 700,
    name = "Adicionar projeto"
)
@Composable
private fun AdicionarProjetoContentPreview() {
    var prioridade by remember {
        mutableStateOf("Média")
    }

    var status by remember {
        mutableStateOf("Quero estudar")
    }

    var observacao by remember {
        mutableStateOf("")
    }

    RepotrackTheme {
        AdicionarProjetoContent(
            repositorio = RepositorioGithubModel(
                githubId = 6296790,
                nome = "spring-boot",
                proprietario = "spring-projects",
                descricao = "Framework Java que facilita a criação de aplicações.",
                linguagem = "Java",
                avatarUrl = null,
                repositorioUrl = "https://github.com/spring-projects/spring-boot",
                estrelas = 74200,
                forks = 40500
            ),
            prioridade = prioridade,
            status = status,
            observacao = observacao,
            onPrioridadeChange = { prioridade = it },
            onStatusChange = { status = it },
            onObservacaoChange = { observacao = it },
            onSalvar = {},
            onFechar = {}
        )
    }
}