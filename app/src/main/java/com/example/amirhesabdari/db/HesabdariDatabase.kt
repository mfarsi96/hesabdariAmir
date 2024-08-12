package com.example.amirhesabdari.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.amirhesabdari.db.dao.AccountDao
import com.example.amirhesabdari.db.dao.TransActionDao
import com.example.amirhesabdari.db.models.Account
import com.example.amirhesabdari.db.models.TransAction


@Database(entities = [Account::class, TransAction::class], version = 2,exportSchema = false)
abstract class HesabdariDatabase : RoomDatabase() {


    abstract fun accountDao(): AccountDao
    abstract fun transAction(): TransActionDao

    companion object {


        @Volatile
        private var instance: HesabdariDatabase? = null


        fun getInstance(context: Context): HesabdariDatabase {
            if (instance != null) return instance!!

            synchronized(this){
                instance = Room.databaseBuilder(
                    context,
                    HesabdariDatabase::class.java, "hesabdari.db"
                ).fallbackToDestructiveMigration().build()
            }



            return instance!!
        }
    }
}