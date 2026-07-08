package com.example.repotrack.data.remote.api

import com.example.repotrack.data.remote.dto.RepotrackSaveDto
import com.example.repotrack.data.remote.dto.RepotrackSaveResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RepotrackApi {

    @POST("/repositories")
    suspend fun criar(@Body dto: RepotrackSaveDto) : RepotrackSaveResponse
}