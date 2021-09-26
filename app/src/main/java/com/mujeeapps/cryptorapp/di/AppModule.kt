package com.mujeeapps.cryptorapp.di

import com.mujeeapps.cryptorapp.common.CrypAppConstants
import com.mujeeapps.cryptorapp.data.remote.CoinPapricaApi
import com.mujeeapps.cryptorapp.data.repository.ImplCoinRepository
import com.mujeeapps.cryptorapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//This implementation is for HILT dependency injection

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoginInterceptor() : OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(httpLoggingInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun providePapricaApi(builder : OkHttpClient) : CoinPapricaApi {
        return Retrofit.Builder()
            .baseUrl(CrypAppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder)
            .build()
            .create(CoinPapricaApi::class.java)
    }

    @Provides
    @Singleton
    fun providePapricaRepository(api : CoinPapricaApi) : CoinRepository {
        return ImplCoinRepository(api)
    }
}