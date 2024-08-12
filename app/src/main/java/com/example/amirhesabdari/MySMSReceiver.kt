package com.example.amirhesabdari


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {
    val smsViewModel =SmsViewModel()
    companion object {
        private val TAG by lazy { MySMSReceiver::class.java.simpleName }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            val smsMessages = extractMessages.map { it.displayMessageBody }

            smsMessages.forEach { message ->
                Log.d(TAG, "Received SMS: $message")
                // ارسال پیام‌ها به ViewModel
                smsViewModel.addSmsMessage(message)
            }
        }
    }
}
