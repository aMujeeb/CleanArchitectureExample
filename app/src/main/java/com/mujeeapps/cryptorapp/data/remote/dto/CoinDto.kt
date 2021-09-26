package com.mujeeapps.cryptorapp.data.remote.dto

import com.mujeeapps.cryptorapp.domain.models.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        isActive = is_active
    )
}