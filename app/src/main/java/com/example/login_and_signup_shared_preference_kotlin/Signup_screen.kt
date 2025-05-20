package com.example.login_and_signup_shared_preference_kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            val username = binding.etUsername.text.toString().trim() ;
            val password = binding.etPassword.text.toString().trim() ;
            val confirmPassword = binding.etConfirmPassword.text.toString().trim() ;
            when {
                username.isEmpty() -> {
                    binding.etUsername.error = "Username cannot be empty"
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "password cannot be empty"
                }
                confirmPassword.isEmpty()->{
                    binding.etConfirmPassword.error = "Confirm password cannot be empty"
                }
                password != confirmPassword -> {
                    binding.etConfirmPassword.error = "password don't match"
                }
                password.length < 6 -> {
                    binding.etPassword.error = "password must be grater than 6 characters"
                }
                else -> {
                    val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.putBoolean("isLoggedIn", false)
                    editor.apply()

                    Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()

                    // Navigate to Login/Main Activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }
            }




        }



    }
}