package com.example.calculator.presentation
import androidx.lifecycle.ViewModel
import com.example.calculator.data.Exp4jCalc
import com.example.calculator.domain.Calc
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CalculatorViewModel(
    private val calc: Calc = Exp4jCalc()
) : ViewModel(){
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()
    fun onAction(action: CalculatorAction){
        when(action){
            CalculatorAction.OnCalculate -> _state.update {
                val answer = calc.solve(it.expression)
                it.copy(
                    result = if(answer == null) "Syntax ERROR" else answer.formatResult(),
                    expression = if(answer == null) "" else it.expression
                )
            }
            CalculatorAction.OnClear -> _state.value = CalculatorState()
            CalculatorAction.OnDelete -> _state.update{it.copy(
                expression = it.expression.dropLast(1),
                result = "")}
            is CalculatorAction.OnSymbol -> _state.update { it.copy(
                expression = it.expression + action.addSymbol,
                result = "" ) }
        }
    }

    private fun Double.formatResult(): String{
        if(this % 1 == 0.0){
            return this.toInt().toString()
        }
        return this.toString()
    }
}