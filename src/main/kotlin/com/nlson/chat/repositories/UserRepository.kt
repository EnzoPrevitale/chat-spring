package com.nlson.chat.repositories

import com.nlson.chat.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
}