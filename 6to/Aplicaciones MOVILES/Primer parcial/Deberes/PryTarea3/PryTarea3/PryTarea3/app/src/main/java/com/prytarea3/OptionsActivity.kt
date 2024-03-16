package com.prytarea3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class OptionsActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val txtInsert: EditText = findViewById(R.id.txtInsert)
        txtInsert.setText("")

        val radioGroup: RadioGroup = findViewById(R.id.rgOptions)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbFactorialPrime -> {
                    val intent = Intent(this, FactorialPrimeActivity::class.java)
                    intent.putExtra("title", txtInsert.text.toString())
                    startActivity(intent)
                }

                R.id.rbPldCpsAg -> {
                    val intent = Intent(this, PalindCopicDegreesActivity::class.java)
                    intent.putExtra("title", txtInsert.text.toString())
                    startActivity(intent)
                }
            }

        }
    }

    private fun changeWindow() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }
}