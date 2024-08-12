package com.example.amirhesabdari.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var cardNum: String,
    var accountName: String,
    var description: String,
    var balance: Long
)
