package com.example.worlde   // keep or match your own package name

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var letter1: EditText
    private lateinit var letter2: EditText
    private lateinit var letter3: EditText
    private lateinit var letter4: EditText
    private lateinit var letter5: EditText
    private lateinit var letter6: EditText
    private lateinit var letter7: EditText
    private lateinit var letter8: EditText
    private lateinit var letter9: EditText
    private lateinit var letter10: EditText
    private lateinit var letter11: EditText
    private lateinit var letter12: EditText


    val answer = FourLetterWordList.getRandomFourLetterWord().uppercase()
    val answerChars = answer.toCharArray()
    // val answer = "mine"
    var count = 3;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        letter1 = findViewById(R.id.box1)
        letter1.filters = arrayOf(InputFilter.AllCaps())
        letter2 = findViewById(R.id.box2)
        letter2.filters = arrayOf(InputFilter.AllCaps())
        letter3 = findViewById(R.id.box3)
        letter3.filters = arrayOf(InputFilter.AllCaps())
        letter4 = findViewById(R.id.box4)
        letter4.filters = arrayOf(InputFilter.AllCaps())

        letter5 = findViewById(R.id.box5)
        letter5.filters = arrayOf(InputFilter.AllCaps())
        letter6 = findViewById(R.id.box6)
        letter6.filters = arrayOf(InputFilter.AllCaps())
        letter7 = findViewById(R.id.box7)
        letter7.filters = arrayOf(InputFilter.AllCaps())
        letter8 = findViewById(R.id.box8)
        letter8.filters = arrayOf(InputFilter.AllCaps())

        letter9 = findViewById(R.id.box9)
        letter9.filters = arrayOf(InputFilter.AllCaps())
        letter10 = findViewById(R.id.box10)
        letter10.filters = arrayOf(InputFilter.AllCaps())
        letter11 = findViewById(R.id.box11)
        letter11.filters = arrayOf(InputFilter.AllCaps())
        letter12 = findViewById(R.id.box12)
        letter12.filters = arrayOf(InputFilter.AllCaps())





        letter1.moveToNextOnInput(letter2)
        letter2.moveToNextOnInput(letter3)
        letter3.moveToNextOnInput(letter4)

        letter5.moveToNextOnInput(letter6)
        letter6.moveToNextOnInput(letter7)
        letter7.moveToNextOnInput(letter8)

        letter9.moveToNextOnInput(letter10)
        letter10.moveToNextOnInput(letter11)
        letter11.moveToNextOnInput(letter12)

        // Backspace goes to previous
        letter2.moveBackOnDelete(letter1)
        letter3.moveBackOnDelete(letter2)
        letter4.moveBackOnDelete(letter3)

        letter6.moveBackOnDelete(letter5)
        letter7.moveBackOnDelete(letter6)
        letter8.moveBackOnDelete(letter7)

        letter10.moveBackOnDelete(letter9)
        letter11.moveBackOnDelete(letter10)
        letter12.moveBackOnDelete(letter11)

        val submitButton = findViewById<Button>(R.id.subButton)
        val answerBox = findViewById<EditText>(R.id.answer)
        answerBox.setText("$answer was the word")

        submitButton.setOnClickListener{

            if(count == 3) {

                val guess = (letter1.text.toString() + letter2.text.toString() + letter3.text.toString() + letter4.text.toString()).uppercase()
                val guessChars = guess.toCharArray()

                if (guess == answer) {
                    answerBox.visibility = View.VISIBLE
                    Toast.makeText(it.context, "correct", Toast.LENGTH_SHORT).show()
                } else {
                    val display1 = findViewById<EditText>(R.id.check1)
                    val display2 = findViewById<EditText>(R.id.guess2)

                    val b5 = findViewById<EditText>(R.id.box5)
                    val b6 = findViewById<EditText>(R.id.box6)
                    val b7 = findViewById<EditText>(R.id.box7)
                    val b8 = findViewById<EditText>(R.id.box8)

                    val bc1 = findViewById<EditText>(R.id.checkBox1)
                    val bc2 = findViewById<EditText>(R.id.checkBox2)
                    val bc3 = findViewById<EditText>(R.id.checkBox3)
                    val bc4 = findViewById<EditText>(R.id.checkBox4)

                    display1.visibility = View.VISIBLE
                    display2.visibility = View.VISIBLE

                    bc1.visibility = View.VISIBLE
                    bc2.visibility = View.VISIBLE
                    bc3.visibility = View.VISIBLE
                    bc4.visibility = View.VISIBLE

                    b5.visibility = View.VISIBLE
                    b6.visibility = View.VISIBLE
                    b7.visibility = View.VISIBLE
                    b8.visibility = View.VISIBLE

                    val checkBoxes1 = arrayOf(bc1,bc2,bc3,bc4)

                    for (i in guessChars.indices) {
                        if (guessChars[i] == answerChars[i]) {
                            // Correct letter in the correct position
                            checkBoxes1[i].setText("O")
                        } else if (guessChars[i] in answerChars) {
                            // Correct letter but wrong position
                            checkBoxes1[i].setText("+")
                        } else {
                            // Letter not in the answer
                           checkBoxes1[i].setText("X")
                        }
                    }

                    letter5.requestFocus()
                    count--
                    Toast.makeText(it.context, "You have $count guesses left", Toast.LENGTH_SHORT).show()
                }
            }
            else if(count == 2){

                val guess = (letter5.text.toString() + letter6.text.toString() + letter7.text.toString() + letter8.text.toString()).uppercase()
                val guessChars = guess.toCharArray()

                if (guess == answer) {
                    answerBox.visibility = View.VISIBLE
                    Toast.makeText(it.context, "correct", Toast.LENGTH_SHORT).show()
                } else {
                    val display3 = findViewById<EditText>(R.id.check2)
                    val display4 = findViewById<EditText>(R.id.guess3)

                    val b9 = findViewById<EditText>(R.id.box9)
                    val b10 = findViewById<EditText>(R.id.box10)
                    val b11 = findViewById<EditText>(R.id.box11)
                    val b12 = findViewById<EditText>(R.id.box12)

                    val bc5 = findViewById<EditText>(R.id.checkBox5)
                    val bc6 = findViewById<EditText>(R.id.checkBox6)
                    val bc7 = findViewById<EditText>(R.id.checkBox7)
                    val bc8 = findViewById<EditText>(R.id.checkBox8)

                    display3.visibility = View.VISIBLE
                    display4.visibility = View.VISIBLE

                    bc5.visibility = View.VISIBLE
                    bc6.visibility = View.VISIBLE
                    bc7.visibility = View.VISIBLE
                    bc8.visibility = View.VISIBLE

                    b9.visibility = View.VISIBLE
                    b10.visibility = View.VISIBLE
                    b11.visibility = View.VISIBLE
                    b12.visibility = View.VISIBLE

                    val checkBoxes2 = arrayOf(bc5,bc6,bc7,bc8)

                    for (i in guessChars.indices) {
                        if (guessChars[i] == answerChars[i]) {
                            // Correct letter in the correct position
                            checkBoxes2[i].setText("O")
                        } else if (guessChars[i] in answerChars) {
                            // Correct letter but wrong position
                            checkBoxes2[i].setText("+")
                        } else {
                            // Letter not in the answer
                            checkBoxes2[i].setText("X")
                        }
                    }

                    letter9.requestFocus()
                    count--
                    Toast.makeText(it.context, "You have $count guesses left", Toast.LENGTH_SHORT).show()
                }
            }

            else if (count == 1){

                val guess = (letter9.text.toString() + letter10.text.toString() + letter11.text.toString() + letter12.text.toString()).uppercase()
                val guessChars = guess.toCharArray()

                if (guess == answer) {
                    answerBox.visibility = View.VISIBLE
                    Toast.makeText(it.context, "correct", Toast.LENGTH_SHORT).show()
                } else {


                    val display5 = findViewById<EditText>(R.id.check3)
                    display5.visibility = View.VISIBLE

                    val bc9 = findViewById<EditText>(R.id.checkBox9)
                    val bc10 = findViewById<EditText>(R.id.checkBox10)
                    val bc11 = findViewById<EditText>(R.id.checkBox11)
                    val bc12 = findViewById<EditText>(R.id.checkBox12)

                    bc9.visibility = View.VISIBLE
                    bc10.visibility = View.VISIBLE
                    bc11.visibility = View.VISIBLE
                    bc12.visibility = View.VISIBLE

                    val checkBoxes3 = arrayOf(bc9,bc10,bc11,bc12)

                    for (i in guessChars.indices) {
                        if (guessChars[i] == answerChars[i]) {
                            // Correct letter in the correct position
                            checkBoxes3[i].setText("O")
                        } else if (guessChars[i] in answerChars) {
                            // Correct letter but wrong position
                            checkBoxes3[i].setText("+")
                        } else {
                            // Letter not in the answer
                            checkBoxes3[i].setText("X")
                        }
                    }

                    answerBox.visibility = View.VISIBLE
                    Toast.makeText(it.context, "No more guesses, the word was $answer", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

/** Extension to jump to the next field once a single character is typed */
fun EditText.moveToNextOnInput(next: EditText?) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s?.length == 1) next?.requestFocus()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

/** Extension to move back when deleting on an empty field */
fun EditText.moveBackOnDelete(prev: EditText?) {
    this.setOnKeyListener { _, keyCode, event ->
        if (keyCode == KeyEvent.KEYCODE_DEL &&
            event.action == KeyEvent.ACTION_DOWN &&
            text.isEmpty()
        ) {
            prev?.requestFocus()
            true
        } else {
            false
        }
    }
}
