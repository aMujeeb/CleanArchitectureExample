package com.mujeeapps.cryptorapp.domain.use_cases.get_coins

import com.mujeeapps.cryptorapp.common.Resource
import com.mujeeapps.cryptorapp.data.remote.dto.toCoin
import com.mujeeapps.cryptorapp.data.repository.models.Coin
import com.mujeeapps.cryptorapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            //For Progress Bar
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Could n't reach Server. Please check your network connection"))
        }
    }
}