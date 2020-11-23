package com.example.riveapp4a.injection

import com.example.riveapp4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}