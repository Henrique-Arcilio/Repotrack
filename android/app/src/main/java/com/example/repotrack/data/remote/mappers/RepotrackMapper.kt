package com.example.repotrack.data.remote.mappers

import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.model.RepositorioRepotrackModel
import com.example.repotrack.data.remote.dto.RepotrackSaveResponse
import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

fun RepotrackSaveResponse.toModel() : RepositorioRepotrackModel{
    return RepositorioRepotrackModel(
        githubId = githubId,
        nome = name,
        proprietario = fullName,
        descricao = description,
        linguagem = language,
        avatarUrl = avatarUrl,
        repositorioUrl = repositoryUrl,
        estrelas = stars,
        forks = forks,
        status = status,
        prioridade = priority,
        criadoEm = createdAt.toString(),
    )
}