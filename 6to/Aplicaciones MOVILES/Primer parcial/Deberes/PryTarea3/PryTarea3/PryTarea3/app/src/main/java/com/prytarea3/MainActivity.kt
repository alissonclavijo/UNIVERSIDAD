package com.prytarea3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = "admin"
        val password = "admin"

        val txtUser: EditText = findViewById(R.id.txtUser)
        val txtPassword: EditText = findViewById(R.id.txtPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if (txtUser.text.toString().isNotEmpty() && txtPassword.text.toString().isNotEmpty()
                && txtUser.text.toString() == user && txtPassword.text.toString() == password
            ) {
                Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                changeWindow()
            } else {
                Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun changeWindow() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

}