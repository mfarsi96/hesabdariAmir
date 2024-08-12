package com.example.amirhesabdari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.amirhesabdari.db.viewmodels.DBViewModel
import com.example.amirhesabdari.ui.theme.AmirHesabdariTheme
import com.example.amirhesabdari.viewModels.SmsViewModel
import com.example.amirhesabdari.viewModels.SmsViewModelFactory

class MainActivity : ComponentActivity() {

    val smsViewModel: SmsViewModel by viewModels { SmsViewModelFactory() }
    private lateinit var viewModel: DBViewModel
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your app.
        } else {
            // Explain to the user that the feature is unavailable because the
            // features requires a permission that the user has denied.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmirHesabdariTheme {

            }
        }
    }
}
