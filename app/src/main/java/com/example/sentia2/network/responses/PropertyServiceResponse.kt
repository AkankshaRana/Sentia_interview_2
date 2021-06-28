package com.example.sentia2.network.responses

import com.example.sentia2.network.model.PropertyDTO
import com.google.gson.annotations.SerializedName

data class PropertyServiceResponse(

    @SerializedName(value = "data")
    var properties: List<PropertyDTO>,
)