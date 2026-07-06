package com.example.repotrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun InformacoesRepositorio(
    linguagem: String?,
    estrelas: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(Color(0xFF2563EB))
        )

        Text(
            text = linguagem ?: "Não informada",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = "Estrelas",
            modifier = Modifier.size(18.dp),
            tint = Color(0xFFF59E0B)
        )

        Text(
            text = formatarNumero(estrelas),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun formatarNumero(numero: Int): String {
    return when {
        numero >= 1_000_000 -> {
            String.format("%.1fM", numero / 1_000_000.0)
        }

        numero >= 1_000 -> {
            String.format("%.1fk", numero / 1_000.0)
        }

        else -> numero.toString()
    }
}

@Preview(
    showBackground = true,
    widthDp = 220
)
@Composable
private fun InformacoesRepositorioPreview() {
    RepotrackTheme {
        InformacoesRepositorio(
            linguagem = "Java",
            estrelas = 74200
        )
    }
}