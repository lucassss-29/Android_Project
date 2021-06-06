package com.example.advertise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_paint)
        val intent = Intent(this, PaintActivity::class.java)
        startActivity(intent)
    }
}