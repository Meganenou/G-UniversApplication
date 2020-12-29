package com.example.g_universapplication.domain.usecase

import com.example.g_universapplication.data.repository.UserRepository
import com.example.g_universapplication.domain.entities.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest {

    private val userRepository: UserRepository = mockk()

    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            val user = User("")
            coEvery { userRepository.createUser(user) } returns Unit

            classUnderTest.invoke(user)

            coVerify(exactly = 1 ) {userRepository.createUser(user)}
        }
    }
}
