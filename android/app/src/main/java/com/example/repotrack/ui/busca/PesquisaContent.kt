package com.example.repotrack.ui.busca

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repotrack.data.model.RepositorioModel
import com.example.repotrack.ui.components.BotaoPesquisar
import com.example.repotrack.ui.components.CampoPesquisa
import com.example.repotrack.ui.components.CardRepositorio
import com.example.repotrack.ui.theme.RepotrackTheme

@Composable
fun PesquisaContent(
    termo: String,
    repositorios: List<RepositorioModel>,
    carregando: Boolean,
    onTermoChange: (String) -> Unit,
    onPesquisar: () -> Unit,
    onRepositorioClick: (String, String) -> Unit
){
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("RepoTrack", style = MaterialTheme.typography.headlineMedium)
        Text("Encontre projetos para estudar")
        Spacer(Modifier.height(16.dp))

        CampoPesquisa(termo, onTermoChange, onPesquisar)
        Spacer(Modifier.height(16.dp))

        BotaoPesquisar(
            carregando = carregando,
            habilitado = termo.isNotBlank(),
            onClick = onPesquisar,
            texto = "Pesquisar"
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = repositorios,
                key = { it.githubId }
            ) { repositorio ->
                CardRepositorio(
                    repositorio = repositorio,
                    onDetalhesClick = onRepositorioClick
                )
            }
        }
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 390,
//    heightDp = 800
//)
//@Composable
//private fun PesquisaContentPreview() {
//    RepotrackTheme {
//        PesquisaContent(
//            termo = "spring",
//            repositorios = RepositoriosFake.lista,
//            carregando = false,
//            onTermoChange = {},
//            onPesquisar = {},
//            onRepositorioClick = {}
//        )
//    }
//}

