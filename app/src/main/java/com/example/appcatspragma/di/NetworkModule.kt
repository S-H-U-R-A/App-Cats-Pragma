package com.example.appcatspragma.di


import com.example.appcatspragma.data.remote.retrofit.CatsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCatService() : CatsApiService{

        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create( CatsApiService::class.java )

    }


}