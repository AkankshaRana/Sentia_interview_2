package com.example.sentia2.repository

import com.example.sentia2.domain.model.Property

interface PropertyRepository {

    suspend fun get(): List<Property>
}