package com.example.repotrack.ui.rotas

object Rotas {
    const val PESQUISA = "pesquisa"
    const val SALVOS =  "salvos"
    const val DETALHES = "detalhes/{proprietario}/{nome}"

    fun detalhes(
        proprietario: String,
        nome: String
    ): String {
        return "detalhes/$proprietario/$nome"
    }
}