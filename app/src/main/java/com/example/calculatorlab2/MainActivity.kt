package com.example.calculatorlab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //функція за допомогою якої вписуються значення до строки за натискання кнопки
    private fun addToInputText(buttonValue: String): String {
        return "${numTxt.text}$buttonValue"
    }

    //функція, що перевизначає знаки ділення та множення
    private fun convertor(): String {
        var expression = numTxt.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    //функція, що виводить результат
    private fun output() {
        try {
            val expression = convertor()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                numTxt.text = "Error"
            } else {
                numTxt.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            numTxt.text = "Error"

        }
    }

    //operation buttons
    fun clearButton(view: View) {
        numTxt.text = ""
    }

    fun divideButton(view: View) {
        numTxt.text = addToInputText("÷")
    }

    fun multiplyButton(view: View) {
        numTxt.text = addToInputText("×")
    }

    fun minusButton(view: View) {
        numTxt.text = addToInputText("-")
    }

    fun plusButton(view: View) {
        numTxt.text = addToInputText("+")
    }

    fun equalsButton(view: View) {
        output()
    }

    fun dotButton(view: View) {
        numTxt.text = addToInputText(".")
    }
    fun leftBraketButton(view: View) {
        numTxt.text = addToInputText("(")
    }

    fun rightBraketButton(view: View) {
        numTxt.text = addToInputText(")")
    }
    //Number buttons
    fun zeroButton(view: View) {
        numTxt.text = addToInputText("0")
    }

    fun oneButton(view: View) {
        numTxt.text = addToInputText("1")
    }

    fun twoButton(view: View) {
        numTxt.text = addToInputText("2")
    }

    fun threeButton(view: View) {
        numTxt.text = addToInputText("3")
    }

    fun fourButton(view: View) {
        numTxt.text = addToInputText("4")
    }

    fun fiveButton(view: View) {
        numTxt.text = addToInputText("5")
    }

    fun sixButton(view: View) {
        numTxt.text = addToInputText("6")
    }

    fun sevenButton(view: View) {
        numTxt.text = addToInputText("7")
    }

    fun eightButton(view: View) {
        numTxt.text = addToInputText("8")
    }

    fun nineButton(view: View) {
        numTxt.text = addToInputText("9")
    }

}
