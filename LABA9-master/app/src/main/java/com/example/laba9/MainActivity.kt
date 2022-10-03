package com.example.laba9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dayText : EditText
    private lateinit var monthText : EditText
    private lateinit var yearText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this,Perehod::class.java);
            dayText = findViewById<EditText>(R.id.editTextDate1)
            monthText = findViewById<EditText>(R.id.editTextDate2)
            yearText = findViewById<EditText>(R.id.editTextDate3)
            intent.putExtra("day", dayText.text.toString().toInt())
            intent.putExtra("month", monthText.text.toString().toInt())
            intent.putExtra("year", yearText.text.toString().toInt())
            startActivity(intent);
        }
    }
}