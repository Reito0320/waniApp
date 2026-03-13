package com.example.cat.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// app.listenみたいな感じ。
// クライアント側のAPI通信
object RetrofitClient {
    // HTTPクライアント生成
    private val retrofit = Retrofit.Builder()
        // Spring Bootで飛ばしているURL
        .baseUrl("http://10.0.2.2:8080/")
        // JSONをGSONに変換してkotlinで使えるようにする。
        .addConverterFactory(GsonConverterFactory.create())
        // Retrofitの完成を示すコード
        .build()

    // api変数に型を定義して、serverを作っている。
    val api: ApiService = retrofit.create(ApiService::class.java)
}