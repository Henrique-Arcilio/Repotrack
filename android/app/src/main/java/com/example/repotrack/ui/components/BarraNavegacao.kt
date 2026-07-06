package com.example.repotrack.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.repotrack.ui.rotas.Rotas
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BarraNavegacao(
    rotaAtual: String?,
    onPesquisar: () -> Unit,
    onSalvos: () -> Unit
){
    NavigationBar{
        NavigationBarItem(
            selected = rotaAtual == Rotas.PESQUISA,
            onClick = onPesquisar,
            icon = {Icon(Icons.Default.Search, null)},
            label = { Text("Pesquisar") }
        )

        NavigationBarItem(
            selected = rotaAtual == Rotas.SALVOS,
            onClick = onSalvos,
            icon = {Icon(Icons.Default.Favorite, null)},
            label = { Text("Meus Projetos") }
        )

    }
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun BarraNavegacaoPesquisaPreview() {
    MaterialTheme {
        Surface {
            BarraNavegacao(
                rotaAtual = Rotas.PESQUISA,
                onPesquisar = {},
                onSalvos = {}
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun BarraNavegacaoSalvosPreview() {
    MaterialTheme {
        Surface {
            BarraNavegacao(
                rotaAtual = Rotas.SALVOS,
                onPesquisar = {},
                onSalvos = {}
            )
        }
    }
}