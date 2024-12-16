package com.example.mytodo_firebase.helper

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthHelper {

    companion object{
        val authHelper = AuthHelper()
    }
    val auth = Firebase.auth

    fun singUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e(TAG, "singUp: Successfully....")
        }
            .addOnFailureListener {
                Log.e(TAG, "singUp: Failed....")
            }
    }

    // asynchronization
    suspend fun logIn(email: String, password: String): String? {
        var msg: String? = null

        try {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                Log.e(TAG, "singUp: Successfully....")
                msg = "Successfully"
            }
                .addOnFailureListener {
                    Log.e(TAG, "singUp: Failed....")
                    msg = it.message
                }.await()
        }catch (e:Exception){
            Log.e("Exception", "signIn: ${e.message}")
        }
        return msg
    }

    fun logOut() {
        auth.signOut()
//        Firebase.auth.signOut()
    }
}