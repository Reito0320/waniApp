package com.example.cat.network.response

data class RankingResponse (
    val id: Long,
    val name: String,
    val currentScore: Int,
    val bestScore: Int,
    val bestScoreDateTime: String?
)