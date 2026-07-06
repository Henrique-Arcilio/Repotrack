package com.example.repotrack.data.remote.mappers

import com.example.repotrack.data.model.RepositorioModel
import com.example.repotrack.data.remote.dto.GitHubRepositorioDto

fun GitHubRepositorioDto.toModel(): RepositorioModel{
    return RepositorioModel(
        githubId = id,
        nome = name,
        proprietario = owner.login,
        descricao = description,
        linguagem = language,
        avatarUrl = owner.avatarUrl,
        repositorioUrl = repositoryUrl,
        estrelas = stars,
        forks = forks
    )
}