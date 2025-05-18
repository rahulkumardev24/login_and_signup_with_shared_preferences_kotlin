package com.example.login_and_signup_shared_preference_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login_and_signup_shared_preference_kotlin.databinding.ActivitySingupScreenBinding

class Signup_screen : AppCompatActivity() {
    lateinit var binding: ActivitySingupScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.txtLoginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.btnSignup.setOnClickListener {

        }
    }
}