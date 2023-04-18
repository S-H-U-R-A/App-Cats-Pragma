package com.example.appcatspragma.di

import com.example.appcatspragma.data.datasource.CatsDataSource
import com.example.appcatspragma.data.datasource.CatsNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindCatsDataSource(
        catsNetworkDataSourceImpl: CatsNetworkDataSourceImpl
    ) : CatsDataSource

}