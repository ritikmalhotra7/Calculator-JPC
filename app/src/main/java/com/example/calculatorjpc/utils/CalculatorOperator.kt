package com.example.calculatorjpc.utils

sealed class CalculatorOperator(val symbol:String) {

    object Add: CalculatorOperator("+")
    object Subtract: CalculatorOperator("-")
    object Multiply: CalculatorOperator("*")
    object Divide: CalculatorOperator("/")
}
