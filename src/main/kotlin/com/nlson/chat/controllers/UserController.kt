package com.nlson.chat.controllers

import com.nlson.chat.models.User
import com.nlson.chat.service.UserService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.graphql.data.method.annotation.Argument

@Controller
class UserController(val service: UserService) {

    @QueryMapping("allUsers")
    fun getUsers(): List<User> {
        return service.listUsers()
    }

    @QueryMapping("userById")
    fun getUser(@Argument id: String): User {
        return service.listUserById(id)
    }
}