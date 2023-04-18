package com.example.appcatspragma.data.remote.retrofit

import com.example.appcatspragma.data.model.ResponseCatsList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface CatsApiService {

    @GET("breeds")
    suspend fun getAllCats(
        @Header("x-api-key") apiKey: String
    ) : Flow< ResponseCatsList >


    @GET("images/")
    suspend fun getImage(
        @Header("x-api-key") apiKey: String,
        @Query("") idImage: String
    ) :

}
