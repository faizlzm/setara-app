package com.project.capstone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.capstone.feature.cvGenerator.presentation.CvApp
import com.project.capstone.ui.theme.CapstoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneTheme {
                CvApp()
            }
        }
    }
}