package com.example.repotrack.data.remote.mappers

import com.example.repotrack.data.model.RepositorioGithubModel
import com.example.repotrack.data.remote.dto.GitHubRepositorioDto

fun GitHubRepositorioDto.toModel(): RepositorioGithubModel{
    return RepositorioGithubModel(
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