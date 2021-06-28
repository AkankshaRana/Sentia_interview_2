package com.example.sentia2.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Property(val display_price: String,
               val bedrooms: Int,
               val bathrooms: Int,
               val carspaces: Int,
               val property_type: String,
               val location: Location,
               val property_images: List<PropertyImages>,
               val agent: Agent,
               val description: String
): Parcelable

@Parcelize
class Location(val address: String): Parcelable

@Parcelize
class PropertyImages(val id: Int, val attachment: Images): Parcelable

@Parcelize
class Images(val url: String,
): Parcelable

@Parcelize
class Agent(val first_name: String,
            val last_name: String,
            val company_name:String,
            val avatar: Avatar
): Parcelable

@Parcelize
class Avatar(val small: ImageUrl,
             val medium: ImageUrl,
             val large: ImageUrl): Parcelable

@Parcelize
class ImageUrl(val url: String): Parcelable