package com.example.repotrack.data.repository

import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.remote.api.GitHubApi
import com.example.repotrack.data.remote.client.GitHubRetrofitClient
import com.example.repotrack.data.remote.mappers.toModel

class GitHubRepository(
    private val api: GitHubApi = GitHubRetrofitClient.api
) {
    suspend fun pesquisar(termo: String): List<RepositorioGithubModel> {
        val  resposta = api.pesquiarRepositorios(termo.trim())
        return resposta.items.map { it.toModel() }
    }

    suspend fun buscarDetalhes(
        proprietario: String,
        nome: String
    ): RepositorioGithubModel {
        return api.buscarDetalhes(proprietario, nome).toModel()
    }
}