package com.example.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startNum:Int):ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalSum : LiveData<Int>
        get() = total

    init{
        total.value = startNum
    }
    fun sumUp(input:Int){
        total.value = (total.value)?.plus(input)
    }
}