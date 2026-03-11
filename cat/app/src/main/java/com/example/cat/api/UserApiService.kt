package com.example.cat.api

import com.example.cat.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Long): UserResponse
}