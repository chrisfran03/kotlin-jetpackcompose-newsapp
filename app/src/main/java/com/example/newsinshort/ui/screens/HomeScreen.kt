package com.example.newsinshort.ui.screens
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.data.entity.NewsResponse
import com.example.newsinshort.ui.components.EmptyStateComponent
import com.example.newsinshort.ui.components.Loader
import com.example.newsinshort.ui.components.NewsList
import com.example.newsinshort.ui.components.NewsRowComponent
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes = newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
    initialPageOffsetFraction = 0f,
    ) {
        100
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
        ) { page: Int ->
            when(val result = newsRes.value){
                is ResourceState.Loading -> {
                    Log.d(TAG, "Inside_Loading")
                    Loader()
                }
                is ResourceState.Success -> {
                    val response = (result as ResourceState.Success<NewsResponse>).data
                    Log.d(TAG, "Inside_Success ${response.status} = ${response.totalResults}")
                    if(response.articles.isNotEmpty()) {
                        NewsRowComponent(page, response.articles[page])
                    }else {
                        EmptyStateComponent()
                    }
                }
                is ResourceState.Error -> {
                    val errorMessage = (result as ResourceState.Error<*>).error
                    Log.d(TAG, "Inside_Error $errorMessage")
                }

            }

    }


}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

