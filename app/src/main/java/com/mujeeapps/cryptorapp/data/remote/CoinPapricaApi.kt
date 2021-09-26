package com.mujeeapps.cryptorapp.data.remote

import com.mujeeapps.cryptorapp.data.remote.dto.CoinDetailsDto
import com.mujeeapps.cryptorapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPapricaApi {

    @GET("v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetails(
        @Path("coinId") coinID : String
    ) : CoinDetailsDto
}