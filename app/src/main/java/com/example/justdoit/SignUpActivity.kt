package com.example.justdoit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener(){
            signUp()
        }
        btn_intent_login.setOnClickListener(){
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    fun signUp() {
        if (tv_signup_email.text.toString().isEmpty()) {
            tv_signup_email.error = "Please enter your email"
            tv_signup_email.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tv_signup_email.text.toString()).matches()) {
            tv_signup_email.error = "Please enter a valid email"
            tv_signup_email.requestFocus()
            return
        }
        if (tv_signup_password.text.toString().isEmpty()) {
            tv_signup_email.error = "Please enter your password"
            tv_signup_email.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(
            tv_signup_email.text.toString(),
            tv_signup_password.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Failed to Sign Up, Try Again Later",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}