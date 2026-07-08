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

    suspend fun buscarTodos() : List<RepositorioRepotrackModel>{
        val resposta = api.buscarTodos()
        return resposta.map { it.toModel() }
    }

    suspend fun buscarPorId(id: String) : RepositorioRepotrackModel{
        val resposta = api.buscarPorId(id)
        return resposta.toModel()
    }

    suspend fun deletarPorId(id: String) {
        api.deletarPorId(id)
    }

    suspend fun editar(id: String, dto: RepotrackSaveDto) : RepositorioRepotrackModel{
        val resposta = api.editar(id, dto)
        return resposta.toModel()
    }
}