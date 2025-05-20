package com.example.login_and_signup_shared_preference_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.login_and_signup_shared_preference_kotlin.databinding.ActivitySplashScreenBinding

class Splash_screen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check login session
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                // If already logged in, go to Home
                startActivity(Intent(this, home_screen::class.java))
            } else {
                // Otherwise, go to Signup or Login
                startActivity(Intent(this, Signup_screen::class.java))
            }
            finish()
        }, 3000)
    }
}
