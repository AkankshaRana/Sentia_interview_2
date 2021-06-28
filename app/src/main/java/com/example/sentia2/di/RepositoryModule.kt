package com.example.sentia2.di

import com.example.sentia2.network.PropertyService
import com.example.sentia2.network.model.PropertyDTOMapper
import com.example.sentia2.repository.PropertyRepository
import com.example.sentia2.repository.PropertyRepository_impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePropertyRepository(propertyService: PropertyService
                                  ,propertyDTOMapper: PropertyDTOMapper
    ): PropertyRepository {
        return PropertyRepository_impl(
            propertyService = propertyService,
            mapper = propertyDTOMapper
        )
    }
}