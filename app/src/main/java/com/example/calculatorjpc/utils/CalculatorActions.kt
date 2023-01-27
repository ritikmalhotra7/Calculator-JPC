package com.example.calculatorjpc.utils

sealed class CalculatorActions(){
    data class Numbers(val number:Int): CalculatorActions()
    data class Operation(val operator: CalculatorOperator): CalculatorActions()

    object Clear : CalculatorActions()
    object Delete : CalculatorActions()
    object Decimal : CalculatorActions()
    object Calculate : CalculatorActions()

}
