package com.example.amirhesabdari.db.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amirhesabdari.db.models.Account
import com.example.amirhesabdari.db.repository.AccountRepository

class AccountViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: AccountRepository = AccountRepository(application)
    private var allAccountList = repository.getAllAccount()

    suspend fun insertAccount(account: Account) {
        repository.insertAccount(account)
    }

    suspend fun updateAccount(account: Account) {
        if (account.id <= 0) return
        repository.updateAccount(account)
    }

    suspend fun deleteAccount(account: Account) {
        if (account.id <= 0) return
        repository.deleteAccount(account)
    }

    fun getAllData(): LiveData<List<Account>> {
        return allAccountList
    }
}
class AccountViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AccountViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
