package com.example.riveapp4a.Presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riveapp4a.domain.entity.User
import com.example.riveapp4a.domain.usecase.CreateUserUseCase
import com.example.riveapp4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val counter: MutableLiveData<String> = MutableLiveData()
    init {
        counter.value = "List of users : "
    }
    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user= getUserUseCase.invoke("test")
            val debug = "debug"
        }
    }
}
