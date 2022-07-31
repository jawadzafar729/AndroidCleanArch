package com.test.ahoy.core.utils

import com.test.ahoy.core.data.source.local.entity.ChargingStationEntity
import com.test.ahoy.core.data.source.remote.response.ChargingStationResponse
import com.test.ahoy.core.domain.model.ChargingStation

object DataMapper {

    fun mapResponsesToEntities(input: List<ChargingStationResponse>): List<ChargingStationEntity> {
        val animeList = ArrayList<ChargingStationEntity>()
        input.map {
            val chargingStationEntity = ChargingStationEntity(
                id = it.id,
                canonicalTitle = it.attributes.canonicalTitle,
                startDate = it.attributes.startDate,
                averageRating = it.attributes.averageRating,
                synopsis = it.attributes.synopsis,
                posterImage = it.attributes.posterImage.medium,
                coverImage = it.attributes.coverImage.large,
                youtubeVideoId = it.attributes.youtubeVideoId,
                isFavorite = false
            )
            animeList.add(chargingStationEntity)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<ChargingStationEntity>): List<ChargingStation> =
        input.map {
            ChargingStation(
                id = it.id,
                canonicalTitle = it.canonicalTitle,
                startDate = it.startDate,
                averageRating = it.averageRating,
                synopsis = it.synopsis,
                posterImage = it.posterImage,
                coverImage = it.coverImage,
                youtubeVideoId = it.youtubeVideoId,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: ChargingStation) = ChargingStationEntity(
        id = input.id,
        canonicalTitle = input.canonicalTitle,
        startDate = input.startDate,
        averageRating = input.averageRating,
        synopsis = input.synopsis,
        posterImage = input.posterImage,
        coverImage = input.coverImage,
        youtubeVideoId = input.youtubeVideoId,
        isFavorite = input.isFavorite
    )
}