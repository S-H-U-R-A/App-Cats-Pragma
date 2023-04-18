package com.example.appcatspragma.domain.repository

import com.example.appcatspragma.data.model.ResponseCatsList
import kotlinx.coroutines.flow.Flow

interface CatRepository {

    suspend fun getCats(apiKey: String) : Flow<ResponseCatsList>

}