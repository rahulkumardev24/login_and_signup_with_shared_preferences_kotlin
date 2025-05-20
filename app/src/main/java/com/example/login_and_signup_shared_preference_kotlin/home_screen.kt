package com.example.login_and_signup_shared_preference_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.login_and_signup_shared_preference_kotlin.databinding.ActivityHomeScreenBinding

class home_screen : AppCompatActivity() {

    // View binding object to access views from XML
    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge display
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the custom toolbar as the app bar for this activity
        setSupportActionBar(binding.toolbar)
    }

    // Inflate the menu options from the res/menu/app_bar_menu.xml file
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            // Handle logout button click
            R.id.item_logout -> {
                // Clear stored user data from SharedPreferences
                val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.clear() // Remove all data (like username & password)
                editor.apply()

                // Create intent to navigate back to the login screen
                val intent = Intent(this, MainActivity::class.java)

                // These flags clear the activity stack and prevent the user from going back
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                // Start the login activity
                startActivity(intent)

                true // Return true to indicate the event was handled
            }

            // Default handler for other menu items (if any)
            else -> super.onOptionsItemSelected(item)
        }
    }
}
