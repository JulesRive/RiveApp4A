package com.example.riveapp4a.domain.usecase

import com.example.riveapp4a.data.repository.UserRepository
import com.example.riveapp4a.domain.entity.User

class GetUserUseCase (
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User {
        return userRepository.getUser(email)
    }

}