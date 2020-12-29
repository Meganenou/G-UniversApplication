package com.example.g_universapplication.domain.usecase

import com.example.g_universapplication.data.repository.UserRepository
import com.example.g_universapplication.domain.entities.User


class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String): User? {
        return userRepository.getUser(email)
    }
}