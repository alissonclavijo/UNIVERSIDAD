package com.prytarea3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.EditText
import android.widget.RadioGroup

class PalindCopicDegreesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palind_copic_degrees)

        val txtNumberWorld = findViewById<EditText>(R.id.txtNumberWorld)
        txtNumberWorld.setText(intent.getStringExtra("title"))

        val txtResult = findViewById<TextView>(R.id.txtResult2)

        val radioGroup = findViewById<RadioGroup>(R.id.rgOptionsFactorialPrime)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbPalindrome -> {
                    val isPalindrome = isPalindrome(txtNumberWorld.text.toString())
                    txtResult.text = isPalindrome.toString()
                }

                R.id.rbCopicuo -> {
                    val isCopicuo = isCopicuo(txtNumberWorld.text.toString())
                    txtResult.text = isCopicuo.toString()
                }

                R.id.rbTransformSexagesimals -> {
                    try {
                        val degrees = transformSexagesimal(txtNumberWorld.text.toString())
                        txtResult.text = degrees.toString()
                    } catch (e: Exception) {
                        txtResult.text = "Ingrese solo números"
                    }
                }

                R.id.rbTransformCentesimals -> {
                    try {
                        val degrees = transformCentesimal(txtNumberWorld.text.toString())
                        txtResult.text = degrees.toString()
                    } catch (e: Exception) {
                        txtResult.text = "Ingrese solo números"
                    }
                }
            }
        }

        val btnChangeOptions = findViewById<TextView>(R.id.btnBack)
        btnChangeOptions.setOnClickListener { changeWindow() }
    }

    private fun isPalindrome(word: String): String {
        var isPalindrome = "Es Palindromo"
        if (word.matches(Regex("[a-zA-Z]+"))) {
            val reverse = word.reversed()
            if (word != reverse) {
                isPalindrome = "No es Palindromo"
            }
        } else {
            isPalindrome = "Ingrese solo letras"
        }
        return isPalindrome
    }

    private fun isCopicuo(word: String): String {
        var isCopicuo = "Es Copicuo"
        try {
            val number = word.toInt()
            val reverse = word.reversed()
            if (number != reverse.toInt()) {
                isCopicuo = "No es Copicuo"
            }
        } catch (e: Exception) {
            isCopicuo = "Ingrese solo números"
        }
        return isCopicuo
    }

    //Transform Radians to Degrees Sexagesimal
    private fun transformSexagesimal(word: String): Double {
        var degrees = 0.0
        degrees = word.toDouble() * 180 / Math.PI
        return degrees
    }

    //Transform Radians to Degrees Centesimal
    private fun transformCentesimal(word: String): Double {
        var degrees = 0.0
        degrees = word.toDouble() * 200 / Math.PI
        return degrees
    }

    private fun changeWindow() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

}