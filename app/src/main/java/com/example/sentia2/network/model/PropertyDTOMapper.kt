package com.example.sentia2.network.model

import com.example.sentia2.domain.model.*
import com.example.sentia2.domain.utils.DomainMapper

class PropertyDTOMapper: DomainMapper<PropertyDTO, Property> {
    override fun mapToDomainModel(model: PropertyDTO): Property {
        return Property(
            display_price = model.display_price,
            bedrooms = model.bedrooms,
            bathrooms = model.bathrooms,
            carspaces = model.carspaces,
            property_type = model.property_type,
            location = LocationDTOMapper().mapToDomainModel(model.location),
            property_images = PropertyImagesDTOMapper().toDomainList(model.property_images),
            agent = AgentDTOMapper().mapToDomainModel(model.agent),
            description = model.description
        )
    }

    override fun mapFromDomainModel(domainModel: Property): PropertyDTO {
        return PropertyDTO(
            display_price = domainModel.display_price,
            bedrooms = domainModel.bedrooms,
            bathrooms = domainModel.bathrooms,
            carspaces = domainModel.carspaces,
            property_type = domainModel.property_type,
            location = LocationDTOMapper().mapFromDomainModel(domainModel.location),
            property_images = PropertyImagesDTOMapper().fromDomainList(domainModel.property_images),
            agent = AgentDTOMapper().mapFromDomainModel(domainModel.agent),
            description = domainModel.description
        )
    }
    fun toDomainList(initial: List<PropertyDTO>): List<Property>{
        return initial.map { mapToDomainModel(it) }
    }
}

class LocationDTOMapper: DomainMapper<LocationDTO, Location> {
    override fun mapToDomainModel(model: LocationDTO): Location {
        return Location(
            address = model.address
        )
    }
    override fun mapFromDomainModel(domainModel: Location): LocationDTO {
        return LocationDTO(
            address = domainModel.address
        )
    }
}
class PropertyImagesDTOMapper: DomainMapper<PropertyImagesDTO, PropertyImages> {
    override fun mapToDomainModel(model: PropertyImagesDTO): PropertyImages {
        return PropertyImages(
            id = model.id,
            attachment = ImagesDTOMapper().mapToDomainModel(model.attachment)
        )
    }
    override fun mapFromDomainModel(domainModel: PropertyImages): PropertyImagesDTO {
        return PropertyImagesDTO(
            id = domainModel.id,
            attachment = ImagesDTOMapper().mapFromDomainModel(domainModel.attachment)
        )
    }
    fun toDomainList(initial: List<PropertyImagesDTO>): List<PropertyImages>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<PropertyImages>): List<PropertyImagesDTO>{
        return initial.map { mapFromDomainModel(it) }
    }
}

class ImagesDTOMapper: DomainMapper<ImagesDTO, Images> {
    override fun mapToDomainModel(model: ImagesDTO): Images {
        return Images(
            url = model.url
        )
    }
    override fun mapFromDomainModel(domainModel: Images): ImagesDTO {
        return ImagesDTO(
            url = domainModel.url
        )
    }
}

class AgentDTOMapper: DomainMapper<AgentDTO, Agent> {
    override fun mapToDomainModel(model: AgentDTO): Agent {
        return Agent(
            first_name = model.first_name,
            last_name = model.last_name,
            company_name = model.company_name,
            avatar = AvatarDTOMapper().mapToDomainModel(model.avatar)
        )
    }

    override fun mapFromDomainModel(domainModel: Agent): AgentDTO {
        return AgentDTO(
            first_name = domainModel.first_name,
            last_name = domainModel.last_name,
            company_name = domainModel.company_name,
            avatar = AvatarDTOMapper().mapFromDomainModel(domainModel.avatar)
        )
    }

}

class AvatarDTOMapper: DomainMapper<AvatarDTO, Avatar> {
    override fun mapToDomainModel(model: AvatarDTO): Avatar {
        return Avatar(
            small = ImageURLDTOMapper().mapToDomainModel(model.small),
            medium = ImageURLDTOMapper().mapToDomainModel(model.medium),
            large = ImageURLDTOMapper().mapToDomainModel(model.large)
        )
    }

    override fun mapFromDomainModel(domainModel: Avatar): AvatarDTO {
        return AvatarDTO(
            small = ImageURLDTOMapper().mapFromDomainModel(domainModel.small),
            medium = ImageURLDTOMapper().mapFromDomainModel(domainModel.medium),
            large = ImageURLDTOMapper().mapFromDomainModel(domainModel.large)
        )
    }
}

class ImageURLDTOMapper: DomainMapper<ImageUrlDTO, ImageUrl> {
    override fun mapToDomainModel(model: ImageUrlDTO): ImageUrl {
        return ImageUrl(
            url = model.url
        )
    }

    override fun mapFromDomainModel(domainModel: ImageUrl): ImageUrlDTO {
        return ImageUrlDTO(
            url = domainModel.url
        )
    }

}