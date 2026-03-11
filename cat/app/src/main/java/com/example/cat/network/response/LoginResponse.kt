package com.example.cat.network.response

import java.time.LocalDateTime

// サーバーからのレスポンスをjson形式で受け取る
data class LoginResponse(
    val id: Long,
    val name: String,
    val bestScore: Int,
    val bestScoreDateTime: LocalDateTime
)