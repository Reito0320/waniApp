package com.example.cat.network

import com.example.cat.network.request.GameRequest
import com.example.cat.network.request.LoginRequest
import com.example.cat.network.request.SignOnRequest
import com.example.cat.network.response.GameResponse
import com.example.cat.network.response.LoginResponse
import com.example.cat.network.response.RankingResponse
import com.example.cat.network.response.SignOnResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

//　fetch postみたいな感じ。
interface ApiService {
    @GET("/api/login/{name}")
    suspend fun login (
        @Path("name") name: String
    ): LoginResponse

    @GET("/api/users")
    suspend fun users (): List<RankingResponse>

    @POST("/api/signOn/{name}")
    suspend fun signOn(
        @Path("name") name: String
    ): SignOnResponse

    @PATCH("/api/user/{id}")
    suspend fun scorePatch(
        @Path("id") id: Long,
        @Body request: GameRequest
    ): GameResponse

    @DELETE("/api/user/{id}")
    suspend fun targetDelete(
        @Path("id") id : Long,
    ): Unit
}