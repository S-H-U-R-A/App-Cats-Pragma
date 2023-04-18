package com.example.appcatspragma.data.repository

import android.util.Log
import com.example.appcatspragma.data.datasource.CatsDataSource
import com.example.appcatspragma.data.model.ResponseCatsList
import com.example.appcatspragma.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val catsDataSource: CatsDataSource
) : CatRepository {

    override suspend fun getCats(apiKey: String): Flow<ResponseCatsList> {

        return catsDataSource.getCats(apiKey).transform { listCats ->

            listCats.onEach { cat->

                if( cat.idImage != ""  ){
                    cat.idImage = "https://cdn2.thecatapi.com/images/${cat.idImage}.jpg"
                }else{
                    cat.idImage = "https://www.yourstarnight.com/wp-content/uploads/2018/09/Gato-Negro.png"
                }

            }

            emit(listCats)

        }

    }
}