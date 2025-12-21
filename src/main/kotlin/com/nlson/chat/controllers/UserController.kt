package com.nlson.chat.controllers

import com.nlson.chat.dtos.create.UserDto
import com.nlson.chat.dtos.update.UpdateUserDto
import com.nlson.chat.models.User
import com.nlson.chat.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val service: UserService) {

    @GetMapping
    fun getUsers(): List<User> = service.listUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): User = service.listUserById(id)

    @PostMapping
    fun createUser(@RequestBody input: UserDto): User = service.createUser(input)

    @PatchMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody input: UpdateUserDto): User = service.updateUser(id, input)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): String = service.deleteUser(id)
}