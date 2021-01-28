package com.example.quiztrivia

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val questions = ArrayList<String>()
    private val answer1 = ArrayList<String>()
    private val answer2 = ArrayList<String>()
    private val answer3 = ArrayList<String>()
    private val answer4 = ArrayList<String>()


    lateinit var checkbox1 : RadioButton
    lateinit var checkbox2 : RadioButton
    lateinit var checkbox3 : RadioButton
    lateinit var checkbox4 : RadioButton

    private lateinit var questionText : TextView

    var highScore : Int = 0



    private val correctAnswers = intArrayOf(3, 2, 4, 1, 3, 1, 3, 3, 1, 2, 3, 4, 2, 4, 3)

    var score : Int = 0
    var p : Int =0

    companion object {
        var questionCount: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        questions.add("National Income estimates in India are prepared by")
        questions.add("The staple food of the Vedic Aryan was")
        questions.add("The tropic of cancer does not pass through which of these Indian states ?")
        questions.add("Ctrl, Shift and Alt are called .......... keys.")
        questions.add("MS-Word is an example of _____")
        questions.add("The purest form of iron is ")



        answer1.add("Planning Commission")
        answer1.add("Barley and rice")
        answer1.add("Madhya Pradesh")
        answer1.add("modifier")
        answer1.add("An operating system")



        answer2.add("Reserve Bank of India")
        answer2.add("Milk and its products")
        answer2.add("West Bengal")
        answer2.add("function")
        answer2.add("A processing device")




        answer3.add("Central statistical")
        answer3.add("Rice and pulses")
        answer3.add("Rajasthan")
        answer3.add("alphanumeric")
        answer3.add("Application software")



        answer4.add("Indian statistical Institute")
        answer4.add("Vegetables and fruits")
        answer4.add("Odisha")
        answer4.add("adjustment")
        answer4.add("An input device")

        createQuestionsAndAnswers()

    }


    fun nextClicked(view: View) {
        val button : Button = view as Button
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        if (questionCount <= 5 && (button.text=="Next") || (button.text=="Submit")) {


            var noOptionSelected = false

            if (correctAnswers[p] == 1 && radioGroup.checkedRadioButtonId == R.id.checkBox1) {

                score++

            } else if (correctAnswers[p] == 2 && radioGroup.checkedRadioButtonId == R.id.checkBox2) {

                score++

            } else if (correctAnswers[p] == 3 && radioGroup.checkedRadioButtonId == R.id.checkBox3) {

                score++

            } else if (correctAnswers[p] == 4 && radioGroup.checkedRadioButtonId == R.id.checkBox4) {

                score++

            } else if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "No option selected! Please Select One To Proceed", Toast.LENGTH_SHORT).show()
                noOptionSelected = true
            }

            radioGroup.clearCheck()

            if (!noOptionSelected && questionCount!=5) {
                questionCount++
                createQuestionsAndAnswers()
            }

        }



        if(button.text=="Submit"){

            if(score>highScore){
                highScore=score
            }

            val highText : TextView = findViewById(R.id.textView)
            highText.alpha = 1f

            highText.text = "High Score : $highScore"



            button.text= "Restart"
            radioGroup.alpha = 0F
            questionText.text = "Your Score is $score"

        }else if(button.text=="Restart"){
            button.text="Next"
            radioGroup.alpha=1F
            questionCount=1
            score=0
            val highText : TextView = findViewById(R.id.textView)
            highText.alpha = 0f

            createQuestionsAndAnswers()
        }

        if(questionCount==5 && button.text=="Next"){


            button.text = "Submit"

        }

    }
    private fun createQuestionsAndAnswers(){
        questionText = findViewById(R.id.textView3)

        checkbox1  = findViewById(R.id.checkBox1)
        checkbox2  = findViewById(R.id.checkBox2)
        checkbox3  = findViewById(R.id.checkBox3)
        checkbox4  = findViewById(R.id.checkBox4)

        var n : Int = questionCount-1

        p=n

        questionText.setText(questions.get(n).toString())
        checkbox1.setText(answer1.get(n).toString())
        checkbox2.setText(answer2.get(n).toString())
        checkbox3.setText(answer3.get(n).toString())
        checkbox4.setText(answer4.get(n).toString())


    }

}