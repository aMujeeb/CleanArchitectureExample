package com.mujeeapps.cryptorapp.presentation.coin_details

import com.mujeeapps.cryptorapp.data.repository.models.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
