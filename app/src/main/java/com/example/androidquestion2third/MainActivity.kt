package com.example.androidquestion2third


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var previousButton: ImageButton
    private lateinit var questionTextView: TextView
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        previousButton=findViewById(R.id.previous_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {
           checkAnswer(true)


        }
        falseButton.setOnClickListener {


           checkAnswer(false)

        }
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()

        }

        previousButton.setOnClickListener {

            currentIndex = (currentIndex - 1) % questionBank.size
            if(currentIndex<0)
                currentIndex=questionBank.size-1
            updateQuestion()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId =
            if (userAnswer == correctAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }


    private	fun	updateQuestion()	{
        val	questionTextResId	=	questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)				}



}




