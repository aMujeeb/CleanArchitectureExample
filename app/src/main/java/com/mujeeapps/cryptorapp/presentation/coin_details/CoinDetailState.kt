package com.mujeeapps.cryptorapp.presentation.coin_details

import com.mujeeapps.cryptorapp.domain.models.Coin
import com.mujeeapps.cryptorapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
