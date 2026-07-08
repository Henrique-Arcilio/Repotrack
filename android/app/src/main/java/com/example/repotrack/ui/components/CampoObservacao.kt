package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun CampoObservacao(
    valor: String,
    onValorChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Ex.: começar pelos conceitos básicos"
) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValorChange,
        modifier = modifier
            .fillMaxWidth()
            .height(88.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        maxLines = 3,
        singleLine = false
    )
}

@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Campo de observação vazio"
)
@Composable
private fun CampoObservacaoPreview() {
    RepotrackTheme {
        Surface {
            CampoObservacao(
                valor = "",
                onValorChange = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Campo de observação preenchido"
)
@Composable
private fun CampoObservacaoPreenchidoPreview() {
    RepotrackTheme {
        Surface {
            CampoObservacao(
                valor = "Estudar primeiro a documentação e depois clonar o projeto.",
                onValorChange = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}