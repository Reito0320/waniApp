package com.example.cat.network.request

data class GameRequest (
    val currentScore: Int,
    val bestScore: Int,
    val bestScoreDateTime: String
)