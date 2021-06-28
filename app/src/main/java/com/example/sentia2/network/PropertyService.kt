package com.example.sentia2.network

import com.example.sentia2.network.responses.PropertyServiceResponse
import retrofit2.http.GET

interface PropertyService {

    @GET(".")
    suspend fun getAllProperties(): PropertyServiceResponse
}