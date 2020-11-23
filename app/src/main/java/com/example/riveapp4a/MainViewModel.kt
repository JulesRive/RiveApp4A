package com.example.riveapp4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val text: MutableLiveData<String> = MutableLiveData()
    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        text.value = "Text LiveData"
    }
    fun onIncrement() {
        counter.value = (counter.value ?: 0) + 1
    }
}