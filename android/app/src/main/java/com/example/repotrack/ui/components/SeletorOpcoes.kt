package com.example.repotrack.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun SeletorOpcoes(
    titulo: String,
    opcoes: List<String>,
    opcaoSelecionada: String,
    onOpcaoSelecionada: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = titulo,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            opcoes.forEach { opcao ->
                BotaoOpcao(
                    texto = opcao,
                    selecionado = opcao == opcaoSelecionada,
                    onClick = {
                        onOpcaoSelecionada(opcao)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun BotaoOpcao(
    texto: String,
    selecionado: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(45.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (selecionado) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            }
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selecionado) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            },
            contentColor = if (selecionado) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Seletor de prioridade"
)
@Composable
private fun SeletorPrioridadePreview() {
    RepotrackTheme {
        Surface {
            SeletorOpcoes(
                titulo = "Prioridade",
                opcoes = listOf("Baixa", "Média", "Alta"),
                opcaoSelecionada = "Média",
                onOpcaoSelecionada = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Seletor de status"
)
@Composable
private fun SeletorStatusPreview() {
    RepotrackTheme {
        Surface {
            SeletorOpcoes(
                titulo = "Status",
                opcoes = listOf("Quero estudar", "Estudando", "Concluído"),
                opcaoSelecionada = "Quero estudar",
                onOpcaoSelecionada = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}