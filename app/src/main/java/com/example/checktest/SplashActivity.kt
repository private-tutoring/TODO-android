package com.example.checktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splash()



    }
    fun splash() {
        var h = Handler()
        h.postDelayed({
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }

}