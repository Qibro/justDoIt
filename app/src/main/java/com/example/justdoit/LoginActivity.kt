package com.example.justdoit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener() {
            logIn()
        }

        btn_intent_signup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }

    private fun logIn() {
        if (tv_login_email.text.toString().isEmpty()) {
            tv_login_email.error = "Please enter your email"
            tv_login_email.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tv_login_email.text.toString()).matches()) {
            tv_login_email.error = "Please enter a valid email"
            tv_login_email.requestFocus()
            return
        }
        if (tv_login_password.text.toString().isEmpty()) {
            tv_login_password.error = "Please enter your password"
            tv_login_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(
            tv_login_email.text.toString(),
            tv_login_password.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    updateUI(null)
                }
            }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(
                baseContext, "Failed to Login, Try Again Later",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
