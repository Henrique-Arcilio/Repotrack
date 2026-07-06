package com.example.repotrack.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repotrack.ui.rotas.RepoTrackNavHost
import com.example.repotrack.ui.rotas.Rotas

@Composable
fun RepoTrackApp() {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val rotaAtual = backStackEntry?.destination?.route

    val mostrarBarra =
        rotaAtual == Rotas.PESQUISA ||
                rotaAtual == Rotas.SALVOS

    Scaffold(
        bottomBar = {
            if (mostrarBarra) {
                BarraNavegacao(
                    rotaAtual = rotaAtual,

                    onPesquisar = {
                        navController.navigate(Rotas.PESQUISA) {
                            popUpTo(Rotas.PESQUISA) {
                                inclusive = false
                            }

                            launchSingleTop = true
                        }
                    },

                    onSalvos = {
                        navController.navigate(Rotas.SALVOS) {
                            popUpTo(Rotas.PESQUISA) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingInterno ->
        RepoTrackNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingInterno)
        )
    }
}