package com.example.cat.network.response

import java.time.LocalDateTime

data class GameResponse (
    val id: Long,
    val name: String,
    val bestScore: Int,
    val bestScoreDateTime: LocalDateTime
)