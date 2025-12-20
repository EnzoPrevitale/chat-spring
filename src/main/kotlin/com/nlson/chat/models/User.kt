package com.nlson.chat.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
    @Id val id: String? = null,
    var username: String,
    var email: String,
    var password: String
)
