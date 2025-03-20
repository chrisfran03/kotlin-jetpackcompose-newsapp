package com.example.newsinshort.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsinshort.ui.theme.NewsinShortTheme
import com.example.newsinshort.ui.navigation.AppNavigationGraph
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsinShortTheme {
                 Surface (
                     modifier = Modifier.fillMaxSize().background(Color.White)
                 ) {
                     AppEntryPoint()
                 }

                }
            }
        }
    }

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}
