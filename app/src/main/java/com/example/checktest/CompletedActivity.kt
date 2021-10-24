package com.example.checktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class CompletedActivity : AppCompatActivity() {
    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = PreferenceUtil(applicationContext, getString(R.string.pref_fruit))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed)

        var listFruit = findViewById<LinearLayout>(R.id.list_fruit)

        var all = prefs.getAllString()
        if (all != null) {
            var it = all.entries.iterator()
            while (it.hasNext()) {
                var text = TextView(this)
                text.textSize = 24f
                text.text = it.next().value.toString()
                listFruit.addView(text)
            }
        }
        else {
            var text = TextView(this)
            text.text ="과일 없음"
            listFruit.addView(text)
        }
    }

}