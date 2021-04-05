package com.azamat.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun inputIsNotEmpty(): Boolean {
            var b = true
            if (edit_1.text.toString().trim().isEmpty()) {
                edit_1.error = "НЕ ПУСТОЙ "
                b = false
            }
            if (edit_2.text.toString().trim().isEmpty()){
                edit_2.error = "НЕ ПУСТОЙ"
                b = false
            }
            return b
        }


        fun plus(){
            if (inputIsNotEmpty()) {
                var input1 = edit_1.text.toString().trim().toBigDecimal()
                var input2 = edit_2.text.toString().trim().toBigDecimal()
                textResult.text = input1.add(input2).toString()
            }
        }

        fun minus(){
            if (inputIsNotEmpty()) {
                var input1 = edit_1.text.toString().trim().toBigDecimal()
                var input2 = edit_2.text.toString().trim().toBigDecimal()
                textResult.text = input1.minus(input2).toString()
            }
        }

        fun multiple(){
            if (inputIsNotEmpty()) {
                var input1 = edit_1.text.toString().trim().toBigDecimal()
                var input2 = edit_2.text.toString().trim().toBigDecimal()
                textResult.text = input1.multiply(input2).toString()
            }
        }

        fun divide(){
            if (inputIsNotEmpty()) {
                var input1 = edit_1.text.toString().trim().toBigDecimal()
                var input2 = edit_2.text.toString().trim().toBigDecimal()
                if (input2.compareTo(BigDecimal.ZERO) == 0) {
                    edit_2.error = "Ошибка"
                } else {
                    textResult.text = input1.divide(input2, RoundingMode.HALF_UP).toString()
                }
            }
        }




        button_plus.setOnClickListener {
            plus()
        }

        button_minus.setOnClickListener {
            minus()
        }

        button_multiple.setOnClickListener {
            multiple()
        }

        button_division.setOnClickListener {
            divide()
        }
    }
}