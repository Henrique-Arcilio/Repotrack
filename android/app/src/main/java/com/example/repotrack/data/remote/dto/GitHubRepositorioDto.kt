package com.example.repotrack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GitHubRepositorioDto(
    val id: Long,
    val name: String,
    val description: String,
    val language: String,

    @SerializedName("html_url")
    val repositoryUrl: String,

    @SerializedName("stargazers_count")
    val stars: Int,

    @SerializedName("forks_count")
    val forks: Int,

    val owner: GitHubOwnerDto
)
