package com.example.sentia2.repository

import com.example.sentia2.domain.model.Property
import com.example.sentia2.network.PropertyService
import com.example.sentia2.network.model.PropertyDTOMapper

class PropertyRepository_impl(
    private val propertyService: PropertyService,
    private val mapper: PropertyDTOMapper
): PropertyRepository {

    override suspend fun get(): List<Property> {
        return mapper.toDomainList(propertyService.getAllProperties().properties)
    }
}