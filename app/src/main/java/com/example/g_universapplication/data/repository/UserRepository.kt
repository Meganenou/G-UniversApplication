package com.example.g_universapplication.data.repository

import com.example.g_universapplication.data.local.AppDatabase
import com.example.g_universapplication.data.local.DatabaseDAO
import com.example.g_universapplication.data.local.models.UserLocal
import com.example.g_universapplication.data.local.models.toData
import com.example.g_universapplication.data.local.models.toEntity
import com.example.g_universapplication.domain.entities.User

class UserRepository(
    private val databaseDAO: DatabaseDAO
) {
    suspend fun createUser(user: User){
        databaseDAO.insert(user.toData())
    }

    fun getUser(email: String): User? {
        val userLocal: UserLocal? = databaseDAO.findByName(email)
        return userLocal?.toEntity()
    }
}