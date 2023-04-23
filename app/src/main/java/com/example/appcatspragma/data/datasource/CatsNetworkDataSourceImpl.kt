package com.example.appcatspragma.data.datasource

import com.example.appcatspragma.data.model.ResponseCatsList
import com.example.appcatspragma.data.remote.retrofit.CatsApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CatsNetworkDataSourceImpl @Inject constructor(
    private val catsApiService: CatsApiService
) : CatsDataSource{

    override fun getCats(apiKey: String): Flow<ResponseCatsList> = flow {
        emit( catsApiService.getAllCats(apiKey) )
    }

}