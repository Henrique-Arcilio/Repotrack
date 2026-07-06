package com.example.repotrack.data.repository

import com.example.repotrack.data.model.RepositorioModel
import com.example.repotrack.data.remote.GitHubApi
import com.example.repotrack.data.remote.GitHubRetrofitClient
import com.example.repotrack.data.remote.mappers.toModel

class GitHubRepository(
    private val api: GitHubApi = GitHubRetrofitClient.api
) {
    suspend fun pesquisar(termo: String): List<RepositorioModel> {
        val  resposta = api.pesquiarRepositorios(termo.trim())
        return resposta.items.map { it.toModel() }
    }

    suspend fun buscarDetalhes(
        proprietario: String,
        nome: String
    ): RepositorioModel {
        return api.buscarDetalhes(proprietario, nome).toModel()
    }
}