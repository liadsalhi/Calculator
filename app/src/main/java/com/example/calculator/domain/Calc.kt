package com.example.calculator.domain

interface Calc {
    fun solve(expression : String): Double?
}