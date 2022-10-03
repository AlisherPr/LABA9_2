package com.example.laba9

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Perehod : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var newLayout: ConstraintLayout

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perehod)
        textView = findViewById<TextView>(R.id.textView5)
        newLayout = findViewById(R.id.layout1)
        val day = intent.getIntExtra("day", 0)
        val month = intent.getIntExtra("month", 0)
        val year = intent.getIntExtra("year", 0)

        val date = LocalDateTime.of(year, month, day, 0, 0)
        val dayweek = date.dayOfWeek.value
        when (month) {
            in 1..2 -> {
                textView.text = resources.getText(R.string.winter)
                newLayout.setBackgroundResource(R.drawable.winter)
                if (month==2){
                    if (day>25){
                        Toast.makeText(this,"Вы ввели неправильную дату $day",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            in 3..5 -> {
                textView.text = resources.getText(R.string.spring)
                newLayout.setBackgroundResource(R.drawable.spring)
            }
            in 6..8 -> {
                textView.text = resources.getText(R.string.summer)
                newLayout.setBackgroundResource(R.drawable.summer)
            }
            in 9..11 -> {
                textView.text = resources.getText(R.string.autumn)
                newLayout.setBackgroundResource(R.drawable.autumn)
            }
            12 -> {
                textView.text = resources.getText(R.string.winter)
                newLayout.setBackgroundResource(R.drawable.winter)
            }
        }
        val textView6 = findViewById<TextView>(R.id.textView6).apply {
            when (dayweek) {
                1 -> {
                    text = resources.getText(R.string.Monday)
                }
                2 -> {
                    text = resources.getText(R.string.Tuesday)
                }
                3 -> {
                    text = resources.getText(R.string.Wednesday)
                }
                4 -> {
                    text = resources.getText(R.string.Thursday)
                }
                5 -> {
                    text = resources.getText(R.string.Friday)
                }
                6 -> {
                    text = resources.getText(R.string.Saturday)
                }
                7 -> {
                    text = resources.getText(R.string.Sunday)
                }
            }
        }
        val textView2 = findViewById<TextView>(R.id.textView2).apply {
            text = "day = $day"
        }
        val textView3 = findViewById<TextView>(R.id.textView3).apply {
            text = "month = $month"
        }
        val textView4 = findViewById<TextView>(R.id.textView4).apply {
            text = "year = $year"
        }
    }
}