package com.example.mytodo_firebase.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mytodo_firebase.databinding.ActivitySingUpBinding
import com.example.mytodo_firebase.helper.AuthHelper.Companion.authHelper

class SingUpActivity : AppCompatActivity() {

    lateinit var singUpBinding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        singUpBinding = ActivitySingUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(singUpBinding.root)

        singUpBinding.loginBtn.setOnClickListener {
            finish()
        }
        singUpBinding.signUpButton.setOnClickListener {
            setsingUp()
        }
    }
    private fun setsingUp() {
        val email = singUpBinding.emailEdit.text.toString()
        val password = singUpBinding.passwordEdit.text.toString()
        val confirmPassword = singUpBinding.confirmPasswordEdit.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password != confirmPassword) {
                singUpBinding.passwordEdit.error = "Password not match"
                singUpBinding.confirmPasswordEdit.error = "Password not match"
            } else {
               authHelper.singUp(email, password)
                finish()
            }
        } else {
            if (email.isEmpty()) {
                singUpBinding.emailEdit.error = "Empty"
            }
            if (password.isEmpty()) {
                singUpBinding.passwordEdit.error = "Empty"
            }
        }
    }
}