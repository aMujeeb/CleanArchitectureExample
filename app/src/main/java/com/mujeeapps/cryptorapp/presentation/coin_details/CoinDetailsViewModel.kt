package com.mujeeapps.cryptorapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mujeeapps.cryptorapp.common.CrypAppConstants
import com.mujeeapps.cryptorapp.common.Resource
import com.mujeeapps.cryptorapp.domain.use_cases.get_coin.GetCoinDetailsUseCase
import com.mujeeapps.cryptorapp.presentation.coins.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val coinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(CrypAppConstants.PARAM_COIN_ID)?.let { coinUd ->
            getCoinDetails(coinUd)
        }
    }

    private fun getCoinDetails(coinId : String) {
        coinDetailsUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data ?: null)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Un Expected Error")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}