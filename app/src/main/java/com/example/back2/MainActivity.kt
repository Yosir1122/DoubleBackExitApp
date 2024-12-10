package com.example.back2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isBackPressedOnce = false
    private val handler = Handler(Looper.getMainLooper())
    private val resetBackPress = Runnable { isBackPressedOnce = false }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed()
            return
        }
        isBackPressedOnce = true
        Toast.makeText(this, "Dasturdan chiqish uchun 2 marta bosing", Toast.LENGTH_SHORT).show()
        handler.postDelayed(resetBackPress, 2000)
    }
}