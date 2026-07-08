package com.example.repotrack.data.model

data class RepositorioGithubModel(

    val githubId: Long,
    val nome: String,
    val proprietario: String,
    val descricao: String?,
    val linguagem: String?,
    val avatarUrl: String?,
    val repositorioUrl: String,
    val estrelas: Int,
    val forks: Int,

)