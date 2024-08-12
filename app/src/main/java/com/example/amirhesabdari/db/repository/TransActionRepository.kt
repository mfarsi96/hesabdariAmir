package com.example.amirhesabdari.db.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.amirhesabdari.db.HesabdariDatabase
import com.example.amirhesabdari.db.dao.TransActionDao
import com.example.amirhesabdari.db.models.Account
import com.example.amirhesabdari.db.models.TransAction

class TransActionRepository(application: Application) {

    private var transActionDao: TransActionDao
    private lateinit var allAccountList: LiveData<List<Account>>

    init {
        val database = HesabdariDatabase.getInstance(application)
        transActionDao = database.transAction()
    }

    suspend fun insertTodo(transAction: TransAction) {
        transActionDao.addTransAction(transAction)
    }

    suspend fun updateToDo(transAction: TransAction) {
        transActionDao.updateTransAction(transAction)
    }

    suspend fun deleteToDo(transAction: TransAction) {
        transActionDao.deleteTransAction(transAction)
    }


}