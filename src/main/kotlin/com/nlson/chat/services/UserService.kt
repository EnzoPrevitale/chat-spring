package com.nlson.chat.services

import com.nlson.chat.dtos.UserDto
import com.nlson.chat.models.User
import com.nlson.chat.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findAll(): List<User> {
        return repository.findAll()
    }

    fun create(dto: UserDto): User {
        val user: User = User(
            username = dto.username,
            email = dto.email,
            password = dto.password
        )
        repository.save(user)
        return user
    }
}