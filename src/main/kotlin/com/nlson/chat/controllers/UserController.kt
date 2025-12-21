package com.nlson.chat.controllers

import com.nlson.chat.dtos.create.UserDto
import com.nlson.chat.dtos.update.UpdateUserDto
import com.nlson.chat.models.User
import com.nlson.chat.service.UserService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping

@Controller
class UserController(val service: UserService) {

    @QueryMapping("allUsers")
    fun getUsers(): List<User> = service.listUsers()

    @QueryMapping("userById")
    fun getUser(@Argument id: String): User = service.listUserById(id)

    @MutationMapping("createUser")
    fun createUser(@Argument input: UserDto): User = service.createUser(input)

    @MutationMapping("updateUser")
    fun updateUser(@Argument id: String, @Argument input: UpdateUserDto): User = service.updateUser(id, input)

    @MutationMapping("deleteUser")
    fun deleteUser(@Argument id: String): String = service.deleteUser(id)
}