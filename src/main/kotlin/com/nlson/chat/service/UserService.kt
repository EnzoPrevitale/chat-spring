package com.nlson.chat.service

import com.nlson.chat.dtos.create.UserDto
import com.nlson.chat.dtos.update.UpdateUserDto
import com.nlson.chat.exceptions.NotFound
import com.nlson.chat.models.User
import com.nlson.chat.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val repository: UserRepository) {

    fun listUsers(): List<User> = repository.findAll()

    fun listUserById(id: String): User = repository.findById(id).orElseThrow { NotFound() }

    fun createUser(dto: UserDto): List<User> {
        val user = User(
            username = dto.username,
            email = dto.email,
            password = dto.password
        )

        repository.save(user)

        return repository.findAll()
    }


    fun updateUser(id: String, dto: UpdateUserDto): List<User> {
        val user: User = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

        if (dto.username != null) user.username = dto.username
        if (dto.email != null) user.email = dto.email
        if (dto.password != null) user.password = dto.password

        return repository.findAll()
    }
    
    fun deleteUser(id: String) {
        val user: User = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

        repository.delete(user)
    }

}