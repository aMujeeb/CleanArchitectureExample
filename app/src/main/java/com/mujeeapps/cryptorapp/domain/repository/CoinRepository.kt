package com.mujeeapps.cryptorapp.domain.repository

import com.mujeeapps.cryptorapp.data.remote.dto.CoinDetailsDto
import com.mujeeapps.cryptorapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinDetailsById(coinId : String) : CoinDetailsDto
}