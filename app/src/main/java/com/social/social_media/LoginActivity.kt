package com.social.social_media

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.textInputEditText)
        passwordEditText = findViewById(R.id.textInputEditText2)
        loginButton = findViewById(R.id.button)



        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            when {
                email.isEmpty() -> {
                    Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_LONG).show()
                }

                !isValidEmail(email) -> {
                    Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_LONG).show()
                }

                password.isEmpty() -> {
                    Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_LONG).show()
                }

                else -> {
                    lifecycleScope.launch {

                    }
                    navigateToHome()
                }
            }


        }


    }



    fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }


}











