package com.mujeeapps.cryptorapp.domain.use_cases.get_coin

import com.mujeeapps.cryptorapp.common.Resource
import com.mujeeapps.cryptorapp.data.remote.dto.getDetail
import com.mujeeapps.cryptorapp.data.repository.models.CoinDetail
import com.mujeeapps.cryptorapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        try {
            //For Progress Bar
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinDetailsById(coinId).getDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Could n't reach Server. Please check your network connection"))
        }
    }
}