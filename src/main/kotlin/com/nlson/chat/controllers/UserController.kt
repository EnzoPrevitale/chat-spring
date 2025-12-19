package com.nlson.chat.controllers

import com.nlson.chat.dtos.UserDto
import com.nlson.chat.models.User
import com.nlson.chat.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/user")
class UserController(
    private val service: UserService
) {

    @GetMapping
    fun get(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(service.findAll())
    }

    @PostMapping
    fun post(@RequestBody dto: UserDto): ResponseEntity<User> {
        val user: User = service.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }
}