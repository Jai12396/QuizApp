package com.example.quiztrivia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        val intent2 : Intent = intent


        val textView : TextView = findViewById(R.id.textView4)
        textView.text = "Your Final Score is ${intent2.getIntExtra("finalScore",0)}"
    }

    fun restart(view : View){

        startActivity(Intent(applicationContext,MainActivity.javaClass))
        finish()
    }
}