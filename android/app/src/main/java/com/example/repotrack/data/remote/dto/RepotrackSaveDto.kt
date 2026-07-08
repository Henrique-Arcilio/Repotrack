package com.example.repotrack.data.remote.dto

import com.example.repotrack.data.remote.enums.Priority
import com.example.repotrack.data.remote.enums.Status

data class RepotrackSaveDto(
    val githubId: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val avatarUrl: String,
    val repositoryUrl: String,
    val stars: Int,
    val forks: Int,
    val priority: Priority,
    val status: Status,
    val notes: String? = null
)
