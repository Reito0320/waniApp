package com.example.cat.network.response


data class SignOnResponse(
    val id: Long,
    val name: String,
    val bestScore: Int,
    val bestScoreDateTime: String?
)