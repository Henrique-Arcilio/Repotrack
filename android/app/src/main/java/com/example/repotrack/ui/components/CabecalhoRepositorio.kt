package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun CabecalhoRepositorio(
    nome: String,
    proprietario: String,
    avatarUrl: String? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AvatarRepositorio(
            nome = nome,
            avatarUrl = avatarUrl
        )

        Spacer(modifier = Modifier.size(12.dp))

        Column {
            Text(
                text = nome,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = proprietario,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 300
)
@Composable
private fun CabecalhoRepositorioPreview() {
    RepotrackTheme {
        Surface {
            CabecalhoRepositorio(
                nome = "spring-boot",
                proprietario = "Al domero"
            )
        }
    }
}