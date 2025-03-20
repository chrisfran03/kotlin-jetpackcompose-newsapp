package com.example.newsinshort.ui.repository
import kotlinx.coroutines.flow.Flow
import com.example.newsinshort.data.datasource.NewsDataSource
import com.example.newsinshort.data.entity.NewsResponse
import com.example.utilities.ResourceState
import retrofit2.Response
import javax.inject.Inject
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
    //    suspend fun getNewsHeadline(country:String) : Response<NewsResponse>{
//         return newsDataSource.getNewsHeadline(country)
//    }
    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadline(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage?: "Some error in flow"))
        }
    }
}