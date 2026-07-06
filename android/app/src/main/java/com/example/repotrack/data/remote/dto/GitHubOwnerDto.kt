package com.example.repotrack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GitHubOwnerDto(
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)
