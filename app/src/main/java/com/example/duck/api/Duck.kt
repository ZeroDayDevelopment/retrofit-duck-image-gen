package com.example.duck.api

import com.example.duck.response.PostData
import retrofit2.http.GET

interface Duck {
    @GET("random")
    suspend fun getDuck():PostData
}