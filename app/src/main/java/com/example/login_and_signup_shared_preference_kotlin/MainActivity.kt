package com.example.login_and_signup_shared_preference_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login_and_signup_shared_preference_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /// get dat from shared preferences
        val sharedPref = getSharedPreferences("UserData" , MODE_PRIVATE)
        val savedUsername = sharedPref.getString("username" , "")
        val savedPassword = sharedPref.getString("password" , "")

        ///
        val username = binding.tfUsername.text.toString().trim()
        val password = binding.tfUserPassword.text.toString().trim()

        // redirect
        binding.txtSignupBtn.setOnClickListener {
            startActivity(Intent(this , Signup_screen::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.tfUsername.text.toString()
            val password = binding.tfUserPassword.text.toString()

            when {
                username.isEmpty() -> {
                    binding.tfUsername.error = "username cannot empty"
                }
                password.isEmpty() -> {
                    binding.tfUserPassword.error = "please enter password"
                }
                username == savedUsername && password == savedPassword -> {
                    Toast.makeText(this , "Login Successfully" , Toast.LENGTH_LONG).show()

                    val intent = Intent(this,home_screen::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    Toast.makeText(this,"plz enter correct username and password" , Toast.LENGTH_SHORT).show()
                }


            }
        }

    }
}