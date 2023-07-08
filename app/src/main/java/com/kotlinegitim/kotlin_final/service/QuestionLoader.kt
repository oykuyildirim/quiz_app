package com.kotlinegitim.kotlin_final.service

import com.kotlinegitim.kotlin_final.model.QuestionObj
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

lateinit var doc: Document
class QuestionLoader {


    fun Questions (url : String) : List<QuestionObj>{


        val ans_questions = mutableListOf<QuestionObj>()

        val questions = mutableListOf<String>()

        doc = Jsoup.connect(url).timeout(15000).get()

        var elements: Elements = doc.getElementsByClass("question")

        for (item in elements) {

           questions.add(item.getElementsByTag("a").text())

        }

        val questions_filtered = questions.filter { !it.isNullOrEmpty() }
            .toList()


        val options = takeOptions()

        val answers = TakeCorrectAnswer()

        for (size in 0..questions_filtered.count()-1){

            ans_questions.add(QuestionObj(questions_filtered.get(size),options.get(size),answers.get(size)))
            println(QuestionObj(questions_filtered.get(size),options.get(size),answers.get(size)))
        }



        return ans_questions
    }

    fun takeOptions() : List<List<String>>{

        var listOptions = mutableListOf<List<String>>()

        var elements: Elements = doc.getElementsByClass("quiz-question-answer")

        for (item in elements) {
            val ans = item.getElementsByClass("question").text()

            val options = ans.split("A) ","B) ", "C) ","D) ")

            val options_filtered = options.filter { !it.isNullOrEmpty() }        // .filterNot { it.isNullOrEmpty() }
                .toList()

            listOptions.add(options_filtered)
        }

        return listOptions

    }

    fun TakeCorrectAnswer():List<String>{

        val answers = mutableListOf<String>()

        var elements: Elements = doc.getElementsByClass("ans-text-color")

        for (item in elements) {

            answers.add(item.text())

        }

        return answers
    }





}