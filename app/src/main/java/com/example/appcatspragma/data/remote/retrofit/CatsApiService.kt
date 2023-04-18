package com.example.appcatspragma.data.remote.retrofit

import com.example.appcatspragma.data.model.ResponseCatsList
import retrofit2.http.GET
import retrofit2.http.Header


interface CatsApiService {

    @GET("breeds")
    suspend fun getAllCats(
        @Header("x-api-key") apiKey: String
    ) : ResponseCatsList


/*    @GET("images/{idImage}")
    suspend fun getImage(
        @Header("x-api-key") apiKey: String,
        @Path("idImage") idImage: String
    ) : CatImage*/

}
