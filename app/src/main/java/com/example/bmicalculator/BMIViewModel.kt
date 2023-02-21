package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    private var height: Float = 0.0f
        get() {return heightInput.toFloatOrNull() ?: 0.0f}

    private var weight: Float = 0.0f
        get() {return weightInput.toFloatOrNull() ?: 0.0f}

    var bmi: Float = 0.0f
        get() {return calculateBMI()}

    fun changeHeightInput(value: String) {
        heightInput = value.replace(",",".")
    }

    fun changeWeightInput(value: String) {
        weightInput = value.replace(",",".")
    }

    private fun calculateBMI(): Float {
        return if ( weight > 0 ) (weight/ (height*height) ) else 0.0f
    }

}