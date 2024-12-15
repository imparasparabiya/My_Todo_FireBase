package com.example.mytodo_firebase.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mytodo_firebase.MainActivity
import com.example.mytodo_firebase.databinding.ActivitySpleshBinding
import com.example.mytodo_firebase.helper.AuthHelper.Companion.authHelper

class SpleshActivity : AppCompatActivity() {

    lateinit var spleshBinding: ActivitySpleshBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        spleshBinding = ActivitySpleshBinding.inflate(layoutInflater)
        setContentView(spleshBinding.root)

        Handler().postDelayed({

            val intent:Intent

            if (authHelper.auth.currentUser == null){
                intent = Intent(this, LoginActivity::class.java)
            }else{
                intent = Intent(this, MainActivity::class.java)
            }
            startActivity(intent)
            finish()
        },3000)

    }
}