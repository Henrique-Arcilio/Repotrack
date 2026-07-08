package com.example.repotrack.data.remote.api

import com.example.repotrack.data.remote.dto.RepotrackSaveDto
import com.example.repotrack.data.remote.dto.RepotrackSaveResponse
import com.example.repotrack.data.remote.dto.RepotrackSearchResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RepotrackApi {

    @POST("repositories")
    suspend fun criar(@Body dto: RepotrackSaveDto) : RepotrackSaveResponse
    @GET("repositories")
    suspend fun buscarTodos() : RepotrackSearchResponse

    @GET("repositories/{id}")
    suspend fun buscarPorId(@Path("id") id: String) : RepotrackSaveResponse

    @DELETE("repositories/{id}")
    suspend fun deletarPorId(@Path("id") id: String) : RepotrackSaveResponse

    @PUT("repositories/{id}")
    suspend fun editar(@Path("id") id: String) : RepotrackSaveResponse
}