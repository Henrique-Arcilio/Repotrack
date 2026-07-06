package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun BotaoPesquisar(
    carregando: Boolean,
    habilitado: Boolean,
    onClick: () -> Unit,
    texto: String = "Pesquisar",
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = habilitado && !carregando,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        if (carregando) {
            CircularProgressIndicator(
                modifier = Modifier.size(22.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            Text(text = texto)
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun BotaoPesquisarPreview() {
    RepotrackTheme {
        Surface {
            BotaoPesquisar(
                carregando = false,
                habilitado = true,
                onClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun BotaoPesquisarCarregandoPreview() {
    RepotrackTheme {
        Surface {
            BotaoPesquisar(
                carregando = true,
                habilitado = true,
                onClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}