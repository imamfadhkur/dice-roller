package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var diceImage: ImageView

        // pendefinisian layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // pendefinisian tombol dan pencocokan id pada activity xml
        val rollButton: Button = findViewById(R.id.roll_button)
        // take action pada tombol yang di definisikan
        rollButton.setOnClickListener{rollDice()}

        val countUp: Button = findViewById(R.id.buttonCountUp)
        countUp.setOnClickListener{countUp()}

        val roleImg: Button = findViewById(R.id.btnDiceImg)
        roleImg.setOnClickListener { rollImg() }

        val reset: Button = findViewById(R.id.reset)
        reset.setOnClickListener {
            val text1: TextView = findViewById(R.id.result_text)
            val text2: TextView = findViewById(R.id.textCountUp)
            val zero = 0
            if (text1.text == "Dice Rolled!"){
                Toast.makeText(this@MainActivity, "teks adalah string", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "merubah menjadi 0", Toast.LENGTH_SHORT).show()
                text1.text = zero.toString()
                text2.text = zero.toString()
            }
        }
    }

    private fun rollImg() {
        val diceImage : ImageView = findViewById(R.id.dice_image)
        val randomInt = (1..6).random()
        val diceImgSource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImgSource)
    }

    private fun rollDice(){
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp(){
        val textValue: TextView = findViewById(R.id.result_text)
        val countUp: TextView = findViewById(R.id.textCountUp)
        if (textValue.text == "Dice Rolled!"){
            countUp.text = "1"
        }else if (textValue.text.toString().toInt() < 6){
            var tambah = textValue.text.toString().toInt()
            tambah++
            countUp.text = tambah.toString()
        }
    }

}