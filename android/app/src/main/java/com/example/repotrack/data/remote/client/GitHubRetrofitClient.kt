package com.example.repotrack.data.remote.client

import com.example.repotrack.data.remote.api.GitHubApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubRetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    val api: GitHubApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }
}