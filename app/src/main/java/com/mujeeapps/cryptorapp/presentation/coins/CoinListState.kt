package com.mujeeapps.cryptorapp.presentation.coins

import com.mujeeapps.cryptorapp.data.repository.models.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)