package com.prytarea3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import java.math.BigInteger


class FactorialPrimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial_prime)

        val txtNumber: EditText = findViewById(R.id.txtNumber)
        txtNumber.setText(intent.getStringExtra("title"))

        val txtResult: TextView = findViewById(R.id.txtResult)

        val radioGroup: RadioGroup = findViewById(R.id.rgOptionsFactorialPrime)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbPalindrome -> {
                    try {
                        val factorial = calculateFactorial(txtNumber.text.toString().toInt())
                        txtResult.text = factorial.toString()
                    } catch (e: Exception) {
                        txtResult.text = "Ingrese solo números"
                    }
                }

                R.id.rbCopicuo -> {
                    try {
                        val isPrime = isPrime(txtNumber.text.toString().toInt())
                        txtResult.text = isPrime.toString()
                    } catch (e: Exception) {
                        txtResult.text = "Ingrese solo números"

                    }
                }
            }
        }

        val btnChangeOptions = findViewById<TextView>(R.id.btnBack2)
        btnChangeOptions.setOnClickListener { changeWindow() }
    }

    private fun calculateFactorial(number: Int): Any {
        var factorial: BigInteger = BigInteger.ONE
        try {
            for (i in 1..number) {
                factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
            }
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            factorial = BigInteger.ZERO
        }
        return factorial
    }

    private fun isPrime(number: Int): String {
        var isPrime = ""
        try {
            for (i in 2..number / 2) {
                if (number % i == 0) {
                    isPrime = "No es primo"
                    break
                } else {
                    isPrime = "Es primo"
                }
            }
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
        }
        return isPrime
    }

    private fun changeWindow() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }
}