package com.mujeeapps.cryptorapp.data.repository.models

import com.mujeeapps.cryptorapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinID : String,
    val coinName : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>
)
