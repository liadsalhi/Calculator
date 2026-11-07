package com.example.calculator.data
import com.example.calculator.domain.Calc
import net.objecthunter.exp4j.ExpressionBuilder

class Exp4jCalc: Calc {
    override fun solve(expression: String): Double? {
        try {
            val result = ExpressionBuilder(expression)
                .build()
                .evaluate()
            return result
        }catch (e: Exception){
            return null
        }
    }
}