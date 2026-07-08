package com.example.repotrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.repotrack.ui.theme.RepotrackTheme
import androidx.compose.material3.Surface

@Composable
fun AvatarRepositorio(
    nome: String,
    avatarUrl: String? = null
) {
    if (avatarUrl.isNullOrBlank()) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nome.firstOrNull()?.uppercase() ?: "?",
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "Avatar",
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary),
            contentScale = ContentScale.Crop

        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 100,
    heightDp = 100,
    name = "Avatar com letra"
)
@Composable
private fun AvatarRepositorioLetraPreview() {
    RepotrackTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AvatarRepositorio(
                    nome = "spring-boot"
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 100,
    heightDp = 100,
    name = "Avatar com imagem"
)
@Composable
private fun AvatarRepositorioImagemPreview() {
    RepotrackTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AvatarRepositorio(
                    nome = "spring-boot",
                    avatarUrl = "https://avatars.githubusercontent.com/u/317776"
                )
            }
        }
    }
}
