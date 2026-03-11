package com.example.cat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // marginみたいなスタイルの制限設定
        enableEdgeToEdge()
        // これがrouterの役割。 このファイルを参照して描画します。
        setContentView(R.layout.activity_main)

        val signOn: Button = findViewById(R.id.signOn)
        val login: Button = findViewById(R.id.login)

        signOn.setOnClickListener {
            val intent1 = Intent(this@MainActivity, SignOn::class.java)
            startActivity(intent1)
        }
        login.setOnClickListener {
            val intent2 = Intent(this@MainActivity, Login::class.java)
            startActivity(intent2)
        }

    }
}