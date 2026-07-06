package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun BotaoAdicionarProjeto(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null
        )

        Text(text = "Adicionar aos meus projetos")
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Botão adicionar projeto"
)
@Composable
private fun BotaoAdicionarProjetoPreview() {
    RepotrackTheme {
        Surface {
            BotaoAdicionarProjeto(
                onClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}