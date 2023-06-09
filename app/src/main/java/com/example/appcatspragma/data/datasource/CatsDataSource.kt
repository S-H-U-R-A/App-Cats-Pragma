package com.example.appcatspragma.data.datasource

import com.example.appcatspragma.data.model.ResponseCatsList
import kotlinx.coroutines.flow.Flow

interface CatsDataSource {
    fun getCats(
        apiKey: String
    ) : Flow<ResponseCatsList>

}