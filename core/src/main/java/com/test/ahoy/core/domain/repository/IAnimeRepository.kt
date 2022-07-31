package com.test.ahoy.core.domain.repository

import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {

    fun getAllAnime(): Flow<Resource<List<ChargingStation>>>

    fun getFavoriteAnime(): Flow<List<ChargingStation>>

    fun setFavoriteAnime(chargingStation: ChargingStation, state: Boolean)

}