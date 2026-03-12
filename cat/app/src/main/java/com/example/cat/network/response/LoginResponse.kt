package com.example.cat.network.response


// サーバーからのレスポンスをjson形式で受け取る
data class LoginResponse(
    val id: Long,
    val name: String,
    val bestScore: Int,
    val bestScoreDateTime: String?
)