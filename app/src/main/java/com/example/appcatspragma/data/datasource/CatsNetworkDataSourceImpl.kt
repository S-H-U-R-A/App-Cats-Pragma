package com.example.appcatspragma.data.datasource

import com.example.appcatspragma.data.model.ResponseCatsList
import com.example.appcatspragma.data.remote.retrofit.CatsApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CatsNetworkDataSourceImpl @Inject constructor(
    private val catsApiService: CatsApiService
) : CatsDataSource{

    override suspend fun getCats(apiKey: String): Flow<ResponseCatsList> = catsApiService.getAllCats(apiKey)


}