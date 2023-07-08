package com.kotlinegitim.kotlin_final.ui.LatestTechTwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.kotlinegitim.kotlin_final.model.QuestionObj
import com.kotlinegitim.kotlin_final.gamemanager.QuizManager
import com.kotlinegitim.kotlin_final.R
import com.kotlinegitim.kotlin_final.databinding.FragmentLatest2Binding


class LatestTechTwoFragment : Fragment() {

    private var _binding: FragmentLatest2Binding? = null

    var part = 0

    lateinit var buttonA : Button
    lateinit var buttonB : Button
    lateinit var buttonC: Button
    lateinit var buttonD : Button
    lateinit var question_text : TextView
    lateinit var scoreText : TextView

    // This property is only valid between onCreateView and
    // onDestroyView.

    var listDraw= mutableListOf<QuestionObj>()
    lateinit var drawListview : ListView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_latest2,null,true)

        buttonA = root.findViewById(R.id.button_A1)
        buttonB = root.findViewById(R.id.button_B1)
        buttonC = root.findViewById(R.id.button_C1)
        buttonD = root.findViewById(R.id.button_D1)
        question_text = root.findViewById(R.id.question1)
        scoreText = root.findViewById(R.id.score1)




        var obj = QuizManager(question_text,
            buttonA,
            buttonB,
            buttonC,
            buttonD,
            scoreText,
            requireActivity(),
            root,
            part,
            "https://www.freetimelearning.com/online-quiz/data-science-quiz.php",
            "https://www.freetimelearning.com/online-quiz/machine-learning-quiz.php",
            "https://www.freetimelearning.com/online-quiz/artificial-intelligence-quiz.php",
            "https://www.freetimelearning.com/online-quiz/deep-learning-quiz.php",
            "https://www.freetimelearning.com/online-quiz/blockchain-quiz.php"
        )

        obj.Manager()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}