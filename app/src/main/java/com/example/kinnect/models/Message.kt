package com.example.kinnect.models

import com.google.firebase.Timestamp

class Message (
    val from: String = "",
    val fromUserId: String = "",
    val fromUserProfilePic: String = "",
    val message: String = "",
    val timestamp: Timestamp = Timestamp.now()
)