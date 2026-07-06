package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun BotaoDetalhes(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun BotaoDetalhesPreview() {
    RepotrackTheme {
        BotaoDetalhes(
            texto = "Ver detalhes",
            onClick = {}

        )
    }
}