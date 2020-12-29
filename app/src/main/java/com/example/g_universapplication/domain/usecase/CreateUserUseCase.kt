package com.example.g_universapplication.domain.usecase

import com.example.g_universapplication.data.repository.UserRepository
import com.example.g_universapplication.domain.entities.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}