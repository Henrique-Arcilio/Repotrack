package com.example.repotrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.repotrack.ui.components.RepoTrackApp
import com.example.repotrack.ui.theme.RepotrackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            RepotrackTheme {
                RepoTrackApp()
            }
        }
    }
}