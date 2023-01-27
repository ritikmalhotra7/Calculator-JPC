package com.example.calculatorjpc.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculatorjpc.utils.CalculatorActions
import com.example.calculatorjpc.utils.CalculatorOperator
import com.example.calculatorjpc.utils.CalculatorState

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorActions) {
        when (action) {
            is CalculatorActions.Numbers -> enterNumber(action.number)
            is CalculatorActions.Operation -> enterOperation(action.operator)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> clear()
            is CalculatorActions.Delete -> delete()
            is CalculatorActions.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) return
        state = state.copy(number2 = state.number2 + number)
    }

    private fun enterOperation(operator: CalculatorOperator) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operator)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (state.operation == null && !state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))

        }
    }

    private fun clear() {
        state = state.copy(number1 = "", number2 = "", operation = null)
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation){
                is CalculatorOperator.Add -> number1+number2
                is CalculatorOperator.Subtract -> number1-number2
                is CalculatorOperator.Multiply -> number1*number2
                is CalculatorOperator.Divide -> number1/number2
                null -> return
            }
            state = state.copy(number1 = result.toString().take(15), number2 = "", operation = null)
        }
    }

    companion object {
        const val MAX_NUM_LENGTH = 8
    }
}


