package com.example.newsinshort.ui.screens
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes = newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        when(val result = newsRes.value){
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
            }
            is ResourceState.Success -> {
                Log.d(TAG, "Inside_Success")

            }
            is ResourceState.Error -> {
                Log.d(TAG, "Inside_Error")
            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

