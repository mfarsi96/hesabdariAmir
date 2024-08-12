package com.example.amirhesabdari.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransAction(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var accountId: Int,
    var type: String,
    var description: String,
    val date: String
)