package com.example.sentia2.network.model


import com.google.gson.annotations.SerializedName

data class PropertyDTO(
    @SerializedName(value = "display_price")
    var display_price: String,

    @SerializedName(value = "bedrooms")
    var bedrooms: Int,

    @SerializedName(value = "bathrooms")
    var bathrooms: Int,

    @SerializedName(value = "carspaces")
    var carspaces: Int,

    @SerializedName(value = "property_type")
    var property_type: String,

    @SerializedName(value = "location")
    var location: LocationDTO,

    @SerializedName(value = "property_images")
    var property_images: List<PropertyImagesDTO>,

    @SerializedName(value = "agent")
    var agent: AgentDTO,

    @SerializedName(value = "description")
    var description: String
)

data class LocationDTO(
    @SerializedName(value = "address")
    var address: String
)

data class PropertyImagesDTO(
    @SerializedName(value = "id")
    var id: Int,

    @SerializedName(value = "attachment")
    var attachment: ImagesDTO
)

data class ImagesDTO(

    @SerializedName(value = "url")
    var url: String
)

data class AgentDTO(
    @SerializedName(value = "first_name")
    var first_name: String,

    @SerializedName(value = "last_name")
    var last_name: String,

    @SerializedName(value = "company_name")
    var company_name:String,

    @SerializedName(value = "avatar")
    var avatar: AvatarDTO
)

data class AvatarDTO(
    @SerializedName(value = "small")
    var small: ImageUrlDTO,

    @SerializedName(value = "medium")
    var medium: ImageUrlDTO,

    @SerializedName(value = "large")
    var large: ImageUrlDTO
)

data class ImageUrlDTO(
    @SerializedName(value = "url")
    var url: String
)