package com.kotlinegitim.kotlin_final.ui.LatestTechThree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kotlinegitim.kotlin_final.gamemanager.QuizManager

import com.kotlinegitim.kotlin_final.R
import com.kotlinegitim.kotlin_final.databinding.FragmentLatest3Binding

class LatestTechThreeFragment : Fragment() {
    private var _binding: FragmentLatest3Binding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    // private val binding get() = _binding!!

    var part = 0

    lateinit var buttonA : Button
    lateinit var buttonB : Button
    lateinit var buttonC: Button
    lateinit var buttonD : Button
    lateinit var question_text : TextView
    lateinit var scoreText : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val root = inflater.inflate(R.layout.fragment_latest3,null,true)

        buttonA = root.findViewById(R.id.button_A3)
        buttonB = root.findViewById(R.id.button_B3)
        buttonC = root.findViewById(R.id.button_C3)
        buttonD = root.findViewById(R.id.button_D3)
        question_text = root.findViewById(R.id.question3)
        scoreText = root.findViewById(R.id.score3)

        var obj = QuizManager(question_text,
            buttonA,
            buttonB,
            buttonC,
            buttonD,
            scoreText,
            requireActivity(),
            root,
            part,
            "https://www.freetimelearning.com/online-quiz/swift-quiz.php",
            "https://www.freetimelearning.com/online-quiz/android-quiz.php",
            "https://www.freetimelearning.com/online-quiz/dotnet-mcq.php",
            "https://www.freetimelearning.com/online-quiz/c-sharp-mcq.php",
            "https://www.freetimelearning.com/online-quiz/ado-dotnet-mcq.php"
            )

        obj.Manager()


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}