package com.test.ahoy.core.domain.usecase

import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class ChargingStationInteractor(private val animeRepository: IAnimeRepository): StationUseCase {
    override fun getAllChargingStation(): Flow<Resource<List<ChargingStation>>> {
        return animeRepository.getAllAnime()
    }

    override fun getFavoriteAnime(): Flow<List<ChargingStation>> {
        return animeRepository.getFavoriteAnime()
    }

    override fun setFavoriteChargingStation(chargingStation: ChargingStation, state: Boolean) {
        return animeRepository.setFavoriteAnime(chargingStation, state)
    }
}