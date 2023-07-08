package com.kotlinegitim.kotlin_final.ui.LatestTechOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.kotlinegitim.kotlin_final.gamemanager.QuizManager
import com.kotlinegitim.kotlin_final.R
import com.kotlinegitim.kotlin_final.databinding.FragmentLatest1Binding
class LatestTechOneFragment : Fragment() {

    private var _binding: FragmentLatest1Binding? = null

    var part = 0

    lateinit var buttonA : Button
    lateinit var buttonB : Button
    lateinit var buttonC: Button
    lateinit var buttonD : Button
    lateinit var question_text : TextView
    lateinit var scoreText : TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_latest1,null,true)


        buttonA = root.findViewById(R.id.button_A)
        buttonB = root.findViewById(R.id.button_B)
        buttonC = root.findViewById(R.id.button_C)
        buttonD = root.findViewById(R.id.button_D)
        scoreText = root.findViewById(R.id.score)

        question_text = root.findViewById(R.id.question)

        var obj = QuizManager(question_text,
            buttonA,
            buttonB,
            buttonC,
            buttonD,
            scoreText,
            requireActivity(),
            root,
            part,
            "https://www.freetimelearning.com/online-quiz/virtual-reality-quiz.php",
            "https://www.freetimelearning.com/online-quiz/augmented-reality-quiz.php",
            "https://www.freetimelearning.com/online-quiz/networking-quiz.php",
            "https://www.freetimelearning.com/online-quiz/5g-network-mcq.php",
            "https://www.freetimelearning.com/online-quiz/microsoft-azure-quiz.php")

        obj.Manager()


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}