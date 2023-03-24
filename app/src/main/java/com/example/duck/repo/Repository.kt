package com.example.duck.repo

import com.example.duck.api.Duck
import com.example.duck.api.RetrofitInstance
import com.example.duck.response.PostData

class Repository {
    suspend fun GetDuck():PostData{
        return RetrofitInstance.api.getDuck()
    }
}