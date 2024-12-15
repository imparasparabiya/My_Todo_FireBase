package com.example.mytodo_firebase.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mytodo_firebase.MainActivity
import com.example.mytodo_firebase.databinding.ActivityLoginBinding
import com.example.mytodo_firebase.helper.AuthHelper.Companion.authHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(loginBinding.root)

        loginBinding.loginButton.setOnClickListener {
            val email = loginBinding.emailId.text.toString()
            val password = loginBinding.passwordId.text.toString()

            GlobalScope.launch {

                val msg = authHelper.logIn(email, password)

                if (msg == "Successfully"){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
        loginBinding.singUpBtn.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
    }
}