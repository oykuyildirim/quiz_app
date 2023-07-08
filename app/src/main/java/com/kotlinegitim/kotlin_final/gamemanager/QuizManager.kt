package com.kotlinegitim.kotlin_final.gamemanager

import android.app.Activity
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kotlinegitim.kotlin_final.gamemanager.QuizManager
import com.kotlinegitim.kotlin_final.R
import com.kotlinegitim.kotlin_final.customadaptor.ToastCustomAdaptor
import com.kotlinegitim.kotlin_final.model.QuestionObj
import com.kotlinegitim.kotlin_final.service.QuestionLoader

class QuizManager {

    var questions_answers = mutableListOf<QuestionObj>()

    var question_text: TextView
    var random_question = 0

    var ques_num = 1


    var ButtonA : Button
    var ButtonB : Button

    var ButtonC : Button
    var ButtonD : Button
    var ScoreText : TextView
    var root : View

    var Url1 : String
    var Url2 : String
    var Url3 : String
    var Url4:String
    var Url5:String

    var point = 5

    var score = 0

    lateinit var act : Activity
    var part : Int = 0

    constructor(Question_text: TextView, buttonA : Button, buttonB: Button, buttonC: Button,
                buttonD: Button, scoreText : TextView, activity: Activity, view: View, Part : Int, url1:String, url2: String,url3:String,url4:String,url5:String){

        question_text = Question_text
        ButtonA = buttonA
        ButtonB = buttonB
        ButtonC = buttonC
        ButtonD = buttonD
        ScoreText = scoreText
        root = view
        part = Part
        act = activity
        Url1 = url1
        Url2 = url2
        Url3 = url3
        Url4 = url4
        Url5 = url5

    }


    fun Manager(){




        if (part  == 0) {
            TakeQuestions(Url1)
        }


        ButtonA.setOnClickListener{

            quizController("Option (A)")

        }

        ButtonB.setOnClickListener{

            quizController("Option (B)")
        }

        ButtonC.setOnClickListener{

            quizController("Option (C)")
        }

        ButtonD.setOnClickListener{

            quizController("Option (D)")


        }
    }

    fun quizController(check  : String){

        if (questions_answers.size > 0) {


            if (questions_answers[random_question]?.answer!!.contains(check)) {

                questions_answers.removeAt(random_question)
                ToastCustomAdaptor(act,
                    R.layout.toast_custom_layout,"True Choice !",
                    R.drawable.resource_true ).showToast()

                android.os.Handler(Looper.getMainLooper()).postDelayed({

                    setQuestions()

                }, 1000)
                score += point
                ScoreText.text = score.toString()



            } else {

                questions_answers.removeAt(random_question)
                ToastCustomAdaptor(act,
                    R.layout.toast_custom_layout,"False Choice !",
                    R.drawable.resource_false
                ).showToast()
                android.os.Handler(Looper.getMainLooper()).postDelayed({

                    setQuestions()

                }, 1000)




            }
        }
        if (questions_answers.size == 0){

            part++
            PartController()

        }

    }


    fun setQuestions(){


        if (questions_answers.size > 0) {
            random_question = (0..questions_answers.size - 1).random()
            question_text.text = "${ques_num})"+ " ${questions_answers[random_question].questions}"

            ButtonA.setText(questions_answers[random_question].options?.get(0).toString())
            ButtonB.setText(questions_answers[random_question].options?.get(1).toString())
            ButtonC.setText(questions_answers[random_question].options?.get(2).toString())
            ButtonD.setText(questions_answers[random_question].options?.get(3).toString())

            ques_num ++

        }

    }


    fun TakeQuestions(url : String) {


        val obj = QuestionLoader()

        Thread {


            questions_answers = obj.Questions(url) as MutableList<QuestionObj>


            act.runOnUiThread {



                ButtonA.visibility = View.VISIBLE
                ButtonB.visibility = View.VISIBLE
                ButtonC.visibility = View.VISIBLE
                ButtonD.visibility = View.VISIBLE
                setQuestions()

            }


        }.start()

    }

    fun PartController(){

        if (part  == 0) {
            TakeQuestions(Url1)
        }

        else if (part == 1){

            TakeQuestions(Url2)
        }

        else if (part == 2){

            TakeQuestions(Url3)
        }

        else if (part == 3){

            TakeQuestions(Url4)
        }

        else if (part == 4){

            TakeQuestions(Url5)
        }

        else if (part >= 5){


            android.os.Handler(Looper.getMainLooper()).postDelayed({

                ToastCustomAdaptor(act,
                    R.layout.toast_custom_layout,"All questions are finished !",
                    R.drawable.resource_false
                ).showToast()

            }, 1000)




        }
    }
}