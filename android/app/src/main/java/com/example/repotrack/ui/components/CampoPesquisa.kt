package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme


@Composable
fun CampoPesquisa(
    valor: String,
    aoAlterarValor: (String) -> Unit,
    aoPesquisar: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = valor,
        onValueChange = aoAlterarValor,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text("Digite uma tecnologia ou repositorio") },
        leadingIcon = { Icon(Icons.Default.Search, null) },
        singleLine = true,
        shape = RoundedCornerShape(16.dp)
    )
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun CampoPesquisaPreview() {
    var pesquisa by remember {
        mutableStateOf("")
    }

    RepotrackTheme {
        CampoPesquisa(
            valor = pesquisa,
            aoAlterarValor = { pesquisa = it },
            aoPesquisar = {}
        )
    }
}