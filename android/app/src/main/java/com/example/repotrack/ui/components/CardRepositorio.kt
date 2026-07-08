package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.repotrack.data.model.RepositorioGithubModel

@Composable
fun CardRepositorio(
    repositorio: RepositorioGithubModel,
    onDetalhesClick: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            CabecalhoRepositorio(
                nome = repositorio.nome,
                proprietario = repositorio.proprietario
            )

            Spacer(modifier = Modifier.size(14.dp))

            Text(
                text = repositorio.descricao ?: "Sem descrição disponível.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.size(12.dp))

            InformacoesRepositorio(
                linguagem = repositorio.linguagem,
                estrelas = repositorio.estrelas
            )

            Spacer(modifier = Modifier.size(16.dp))

            BotaoDetalhes(
                texto = "Ver Detalhes",
                onClick = {
                    onDetalhesClick(repositorio.proprietario, repositorio.nome)

                }
            )
        }
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 390
//)
//@Composable
//private fun CardRepositorioPreview() {
//    RepotrackTheme {
//        CardRepositorio(
//            repositorio = RepositoriosFake.lista.first(),
//            onDetalhesClick = {},
//            modifier = Modifier.padding(16.dp)
//        )
//    }
//}