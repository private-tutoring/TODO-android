package com.example.checktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var prefs: PreferenceUtil
        lateinit var prefs2: PreferenceUtil
    }

    fun check(ch: View, key: String) {
        ch as CheckBox
        if (ch.isChecked) {
            Toast.makeText(this, ch.text, Toast.LENGTH_SHORT).show()
            prefs.setString(key, ch.text.toString());
        } else if (!ch.isChecked) {
            prefs.deleteString(key)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = PreferenceUtil(applicationContext, "fruit")
        prefs2 = PreferenceUtil(applicationContext, "checkBox")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b = findViewById<Button>(R.id.button)
        var b2 = findViewById<Button>(R.id.bt_enter)
        var edFruit = findViewById<EditText>(R.id.ed_frult)
        var listFruit = findViewById<LinearLayout>(R.id.ll)
        var myCkMap = prefs2.getAllString()

        if (myCkMap != null) {
            var iterat = myCkMap.entries.iterator()
            while (iterat.hasNext()) {
                var ch = CheckBox(this)
                var current = iterat.next()

                var currentValue = prefs.getString(current.key, "")
                if (currentValue != "") {
                    ch.isChecked = true
                }
                ch.setOnClickListener {
                    check(it, current.key.toString())
                }
                ch.text = current.value.toString()
                listFruit.addView(ch)
            }
        }

        b2.setOnClickListener {
            var che = CheckBox(this)
            che.text = edFruit.text
            che.setOnClickListener { check(it, edFruit.text.toString()) }
            prefs2.setString(edFruit.text.toString(), edFruit.text.toString())
            listFruit.addView(che)
        }

        b.setOnClickListener {
            var i = Intent(this, CompletedActivity::class.java)
            startActivity(i)
        }
    }
}