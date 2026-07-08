package com.example.repotrack.data.remote.api

import com.example.repotrack.data.remote.dto.GitHubRepositorioDto
import com.example.repotrack.data.remote.dto.GitHubSearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @Headers(
        "Accept: application/vnd.github+json",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("search/repositories")
    suspend fun pesquiarRepositorios(
        @Query("q") termo: String,
        @Query("per_page") quantidade: Int = 20
    ) : GitHubSearchResponse

    @Headers(
        "Accept: application/vnd.github+json",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("repos/{owner}/{repo}")
    suspend fun buscarDetalhes(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): GitHubRepositorioDto

}