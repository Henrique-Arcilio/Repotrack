package com.example.repotrack.data.repository

import com.example.repotrack.data.model.RepositorioRepotrackModel
import com.example.repotrack.data.remote.api.RepotrackApi
import com.example.repotrack.data.remote.client.RepotrackClient
import com.example.repotrack.data.remote.dto.RepotrackSaveDto
import com.example.repotrack.data.remote.mappers.toModel

class RepotrackRepository(
    private val api: RepotrackApi = RepotrackClient.api
) {

    suspend fun salvar(dto: RepotrackSaveDto) : RepositorioRepotrackModel{
        val resposta = api.criar(dto)
        return resposta.toModel()
    }
}