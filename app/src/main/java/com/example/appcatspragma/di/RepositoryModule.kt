package com.example.appcatspragma.di

import com.example.appcatspragma.data.repository.CatRepositoryImpl
import com.example.appcatspragma.domain.repository.CatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCatRepository(
        catRepositoryImpl: CatRepositoryImpl
    ) : CatRepository


}