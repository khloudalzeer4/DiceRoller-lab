package com.exmple.practice_3_classes_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

  lateinit var   imgeDice: ImageView
lateinit var  rollButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{
            for (i  in 1..10 step 2 ) {
                Timer().schedule(1000) {

                }
                main()
            }

        }
        imgeDice=findViewById(R.id.imgeDice)

    }
 private  fun main() {
        //create an object
        val myFirstDice = Dice(6)
        val drawbleResource=   when(myFirstDice.roll()){
         1->R.drawable.img_6
        2->R.drawable.img_5
        3->R.drawable.img_4
        4->R.drawable.img_3
        5->R.drawable.img_2
        else->R.drawable.img_1
        }
     // app:srcCompat="@drawable/img_1"
        imgeDice.setImageResource(drawbleResource)
        println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")
    }

    class Dice (val numSides: Int) { // Primary Constructor

        fun roll(): Int {
            // generate a random number between 1 and 6
            return (1..numSides).random()
        }
    }
}