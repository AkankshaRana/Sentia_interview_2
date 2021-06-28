package com.example.sentia2.di

import com.example.sentia2.network.PropertyService
import com.example.sentia2.network.model.PropertyDTOMapper
import com.google.gson.GsonBuilder
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

    private const val baseURL = "https://f213b61d-6411-4018-a178-53863ed9f8ec.mock.pstmn.io/properties/"

    @Singleton
    @Provides
    fun providePropertyMapper(): PropertyDTOMapper {
        return PropertyDTOMapper()
    }

    @Singleton
    @Provides
    fun providePropertyService(): PropertyService {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(PropertyService::class.java)
    }
}