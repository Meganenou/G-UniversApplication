package com.example.g_universapplication.injection

import android.content.Context
import android.os.Build
import androidx.room.Room
import com.example.g_universapplication.data.local.AppDatabase
import com.example.g_universapplication.data.local.DatabaseDAO
import com.example.g_universapplication.data.repository.UserRepository
import com.example.g_universapplication.domain.entities.User
import com.example.g_universapplication.domain.usecase.CreateUserUseCase
import com.example.g_universapplication.domain.usecase.GetUserUseCase
import com.example.g_universapplication.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory {
        MainViewModel(
            get(),
            get()
        )
    }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }

}

val dataModule = module {
    single{ UserRepository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context){
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    appDatabase.databaseDAO()
}