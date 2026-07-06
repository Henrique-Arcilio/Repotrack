package com.example.repotrack.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun LinkRepositorio(
    url: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Abrir repositório",
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = url,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Preview(
    showBackground = true,
    widthDp = 390,
    name = "Link do repositório"
)
@Composable
private fun LinkRepositorioPreview() {
    RepotrackTheme {
        Surface {
            LinkRepositorio(
                url = "https://github.com/spring-projects/spring-boot",
                onClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
