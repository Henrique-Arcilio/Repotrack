package com.example.repotrack.ui.detalhes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.ui.components.BotaoAdicionarProjeto
import com.example.repotrack.ui.components.CabecalhoDetalhes
import com.example.repotrack.ui.components.CardMetrica
import com.example.repotrack.ui.components.LinkRepositorio
import com.example.repotrack.ui.components.TopoDetalhes
import java.util.Locale

@Composable
fun DetalhesContent(
    repositorio: RepositorioGithubModel,
    onVoltar: () -> Unit,
    onAdicionarProjeto: () -> Unit,
    onAbrirRepositorio: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopoDetalhes(onVoltar = onVoltar)
        }
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            CabecalhoDetalhes(
                nome = repositorio.nome,
                proprietario = repositorio.proprietario,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = repositorio.descricao
                    ?: "Sem descrição disponível.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CardMetrica(
                    valor = formatarNumero(repositorio.estrelas),
                    legenda = "Estrelas",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFF59E0B),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )

                CardMetrica(
                    valor = formatarNumero(repositorio.forks),
                    legenda = "Forks",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )

                CardMetrica(
                    valor = repositorio.linguagem ?: "Não informada",
                    legenda = "Linguagem",
                    modifier = Modifier.weight(1f),
                    icone = {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            LinkRepositorio(
                url = repositorio.repositorioUrl,
                onClick = onAbrirRepositorio
            )

            Spacer(modifier = Modifier.height(22.dp))

            BotaoAdicionarProjeto(
                onClick = onAdicionarProjeto
            )
        }
    }
}

private fun formatarNumero(numero: Int): String {
    return when {
        numero >= 1_000_000 -> {
            String.format(
                Locale.US,
                "%.1fM",
                numero / 1_000_000.0
            )
        }

        numero >= 1_000 -> {
            String.format(
                Locale.US,
                "%.1fk",
                numero / 1_000.0
            )
        }

        else -> numero.toString()
    }
}