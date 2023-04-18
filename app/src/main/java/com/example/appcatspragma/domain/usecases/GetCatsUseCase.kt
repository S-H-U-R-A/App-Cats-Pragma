package com.example.appcatspragma.domain.usecases

import android.util.Log
import com.example.appcatspragma.data.datasource.CatsDataSource
import com.example.appcatspragma.data.model.ResponseCatsList
import com.example.appcatspragma.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private const val API_KEY = "bda53789-d59e-46cd-9bc4-2936630fde39"

class GetCatsUseCase @Inject constructor (
    private val catRepository: CatRepository
) {

    suspend operator fun invoke() : Flow<ResponseCatsList> {
        return catRepository.getCats(API_KEY)
    }

}