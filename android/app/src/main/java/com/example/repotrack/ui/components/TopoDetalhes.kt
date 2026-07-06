package com.example.repotrack.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.repotrack.ui.theme.RepotrackTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopoDetalhes(
    onVoltar: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Detalhes")
        },
        navigationIcon = {
            IconButton(onClick = onVoltar) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "voltar"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Preview(
    showBackground = true,
    widthDp = 390
)
@Composable
private fun TopoDetalhesPreview() {
    RepotrackTheme {
        Surface {
            TopoDetalhes(
                onVoltar = {}
            )
        }
    }
}