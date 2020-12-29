package com.example.g_universapplication.domain.usecase

import com.example.g_universapplication.data.repository.UserRepository
import com.example.g_universapplication.domain.entities.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            val email = ""
            coEvery { userRepository.getUser(email) } returns null

            val result = classUnderTest.invoke(email)

            coVerify(exactly = 1 ) {userRepository.getUser(email)}
            assertEquals(result,null)
        }
    }

    @Test
    fun `invoke with valid email`(){
        runBlocking {
            val email = "a@a.c"
            val expectedUser = User("a@a.c")
            coEvery { userRepository.getUser(email) } returns null

            val result = classUnderTest.invoke(email)

            coVerify(exactly = 1 ) {userRepository.getUser(email)}
            assertEquals(result,expectedUser)
        }
    }
}