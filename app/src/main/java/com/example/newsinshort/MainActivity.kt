package com.example.newsinshort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsinshort.ui.theme.NewsinShortTheme
import com.example.newsinshort.ui.components.AppNavigationGraph
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
