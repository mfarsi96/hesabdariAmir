package com.example.amirhesabdari.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.amirhesabdari.db.models.Account


@Dao
interface AccountDao {


    @Insert
    suspend fun insertAccount(account: Account)

    @Update
    suspend fun updateAccount(account: Account)

    @Delete
    suspend fun deleteAccount(account: Account)

    @Query("SELECT * FROM Account order by id asc")
    fun getAllAccount(): LiveData<List<Account>>


}