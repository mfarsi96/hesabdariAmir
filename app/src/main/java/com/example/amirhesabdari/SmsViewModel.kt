package com.example.amirhesabdari


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SmsViewModel : ViewModel() {
    private val _smsMessages = MutableStateFlow<List<String>>(emptyList())
    val smsMessages: StateFlow<List<String>> = _smsMessages

    fun addSmsMessage(message: String) {
        _smsMessages.value += message
    }
}

class SmsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SmsViewModel::class.java)) {
            return SmsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
