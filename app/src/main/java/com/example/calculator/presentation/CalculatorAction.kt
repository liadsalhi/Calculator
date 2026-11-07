package com.example.calculator.presentation

sealed interface CalculatorAction {
    data class OnSymbol(val addSymbol: String) : CalculatorAction
    data object OnCalculate : CalculatorAction
    data object OnDelete : CalculatorAction
    data object OnClear : CalculatorAction
}