package com.example.jetpack.Udemy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DynamicListViewModel : ViewModel() {

    val textFieldState = MutableLiveData("")

    fun onTextChanged(newValue: String) {
        textFieldState.value = newValue
    }
}