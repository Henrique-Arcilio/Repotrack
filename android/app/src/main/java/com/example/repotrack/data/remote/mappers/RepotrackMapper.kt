package com.example.repotrack.data.remote.mappers

import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.model.RepositorioRepotrackModel
import com.example.repotrack.data.remote.dto.RepotrackSaveDto
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

fun RepositorioGithubModel.toSaveDto(
    prioridade: Priority = Priority.MEDIA,
    status: Status = Status.QUERO_ESTUDAR
): RepotrackSaveDto {
    return RepotrackSaveDto(
        githubId = githubId,
        name = nome,
        fullName = "$proprietario/$nome",
        description = descricao ?: "",
        language = linguagem ?: "",
        avatarUrl = avatarUrl ?: "",
        repositoryUrl = repositorioUrl,
        stars = estrelas,
        forks = forks,
        priority = prioridade,
        status = status
    )
}
