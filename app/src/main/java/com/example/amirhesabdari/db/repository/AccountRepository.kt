package com.example.amirhesabdari.db.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.amirhesabdari.db.HesabdariDatabase
import com.example.amirhesabdari.db.dao.AccountDao
import com.example.amirhesabdari.db.models.Account

class AccountRepository(application: Application) {

    private var accountDao: AccountDao
    private lateinit var allAccountList: LiveData<List<Account>>

    init {
        val database = HesabdariDatabase.getInstance(application)
        accountDao = database.accountDao()
        allAccountList = accountDao.getAllAccount()
    }

    suspend fun insertAccount(account: Account) {
        accountDao.insertAccount(account)
    }

    suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }

    fun getAllAccount(): LiveData<List<Account>> {
        return allAccountList
    }
}