package com.example.login_and_signup_shared_preference_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login_and_signup_shared_preference_kotlin.databinding.ActivitySplashScreenBinding

class Splash_screen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Show splash screen -> Navigate to sign up screen
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Signup_screen::class.java))

        } , 300)
    }
}