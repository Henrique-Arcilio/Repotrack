package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.ui.theme.RepotrackTheme
import androidx.compose.material.icons.filled.Share
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@Composable
fun CardMetrica(
    valor: String,
    legenda: String,
    icone: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier.height(72.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                icone()

                Text(
                    text = valor,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = legenda,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 150,
    heightDp = 110
)
@Composable
private fun CardMetricaPreview() {
    RepotrackTheme {
        Surface {
            CardMetrica(
                valor = "74.2k",
                legenda = "Estrelas",
                icone = {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = Color(0xFFF59E0B)
                    )
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 150,
    heightDp = 110,
    name = "Card de forks"
)
@Composable
private fun CardMetricaForksPreview() {
    RepotrackTheme {
        Surface {
            CardMetrica(
                valor = "40.5k",
                legenda = "Forks",
                icone = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 150,
    heightDp = 110,
    name = "Card de linguagem"
)
@Composable
private fun CardMetricaLinguagemPreview() {
    RepotrackTheme {
        Surface {
            CardMetrica(
                valor = "Java",
                legenda = "Linguagem",
                icone = {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}