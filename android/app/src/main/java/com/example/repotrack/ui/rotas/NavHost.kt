package com.example.repotrack.ui.rotas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.repotrack.ui.busca.PesquisaScreen
import com.example.repotrack.ui.detalhes.DetalhesScreen

@Composable
fun RepoTrackNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Rotas.PESQUISA,
        modifier = modifier
    ) {

        // Tela de pesquisa
        composable(Rotas.PESQUISA) {
            PesquisaScreen(
                onRepositorioClick = { proprietario, nome ->
                    navController.navigate(
                        Rotas.detalhes(
                            proprietario = proprietario,
                            nome = nome
                        )
                    )
                }
            )
        }

        // Tela de projetos salvos
        composable(Rotas.SALVOS) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Meus projetos")
            }
        }

        // Tela de detalhes
        composable(
            route = Rotas.DETALHES,
            arguments = listOf(
                navArgument("proprietario") {
                    type = NavType.StringType
                },
                navArgument("nome") {
                    type = NavType.StringType
                }
            )
        ) { entrada ->

            val proprietario = entrada.arguments
                ?.getString("proprietario")
                .orEmpty()

            val nome = entrada.arguments
                ?.getString("nome")
                .orEmpty()

            val uriHandler = LocalUriHandler.current

            if (proprietario.isBlank() || nome.isBlank()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Repositório inválido")
                }
            } else {
                DetalhesScreen(
                    proprietario = proprietario,
                    nome = nome,

                    onVoltar = {
                        navController.popBackStack()
                    },

                    onAbrirRepositorio = { url ->
                        uriHandler.openUri(url)
                    }
                )
            }
        }
    }
}