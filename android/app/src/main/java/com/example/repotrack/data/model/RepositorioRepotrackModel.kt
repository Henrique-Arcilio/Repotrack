package com.example.repotrack.data.model

import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

data class RepositorioRepotrackModel(
    val id: String,
    val githubId: Long,
    val nome: String,
    val proprietario: String,
    val descricao: String?,
    val linguagem: String?,
    val avatarUrl: String?,
    val repositorioUrl: String,
    val estrelas: Int,
    val forks: Int,


    val prioridade: Priority,
    val status: Status,
    val observacoes: String = "",
    val criadoEm: String = ""
)
