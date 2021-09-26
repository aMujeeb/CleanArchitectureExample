package com.mujeeapps.cryptorapp.data.repository

import com.mujeeapps.cryptorapp.data.remote.CoinPapricaApi
import com.mujeeapps.cryptorapp.data.remote.dto.CoinDetailsDto
import com.mujeeapps.cryptorapp.data.remote.dto.CoinDto
import com.mujeeapps.cryptorapp.domain.repository.CoinRepository
import javax.inject.Inject

class ImplCoinRepository @Inject constructor(
    private val api : CoinPapricaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetailsById(coinId: String): CoinDetailsDto {
        return api.getCoinDetails(coinId)
    }
}