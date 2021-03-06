package com.example.riveapp4a.injection

import android.content.Context
import androidx.room.Room
import com.example.riveapp4a.Presentation.main.MainViewModel
import com.example.riveapp4a.data.local.AppDatabase
import com.example.riveapp4a.data.local.DatabaseDao
import com.example.riveapp4a.data.repository.UserRepository
import com.example.riveapp4a.domain.usecase.CreateUserUseCase
import com.example.riveapp4a.domain.usecase.GetUserUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}
val domainModule : Module = module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get())}
}
val dataModule : Module = module{
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
