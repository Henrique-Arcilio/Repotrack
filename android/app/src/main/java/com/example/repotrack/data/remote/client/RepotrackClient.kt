package com.example.repotrack.data.remote.client

import com.example.repotrack.data.remote.api.RepotrackApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RepotrackClient {
    private const val BASE_URL = "https://repotrack-wpk1.onrender.com/api/v1/"

    val api: RepotrackApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RepotrackApi::class.java)
    }
}