package com.example.amirhesabdari.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.amirhesabdari.db.models.TransAction

@Dao
interface TransActionDao {

    @Insert
    suspend fun addTransAction(transAction: TransAction)

    @Delete
    suspend fun deleteTransAction(transAction: TransAction)

    @Update
    suspend fun updateTransAction(transAction: TransAction)


}