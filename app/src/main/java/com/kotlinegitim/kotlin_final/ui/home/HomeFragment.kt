package com.kotlinegitim.kotlin_final.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kotlinegitim.kotlin_final.*
import com.kotlinegitim.kotlin_final.databinding.FragmentHomeBinding
import com.kotlinegitim.kotlin_final.model.QuestionObj

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    var part = 0

    lateinit var buttonA1 : Button
    lateinit var buttonB1 : Button
    lateinit var buttonC1: Button
    lateinit var buttonD1 : Button

    var questions_answers = mutableListOf<QuestionObj>()

    lateinit var question_text : TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home,null,true)



        return root
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}