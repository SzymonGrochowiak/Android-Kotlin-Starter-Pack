package com.szymongrochowiak.androidkotlinstarterpack.di

import android.app.Application
import com.squareup.moshi.Moshi
import com.szymongrochowiak.androidkotlinstarterpack.data.local.LocalRepository
import com.szymongrochowiak.androidkotlinstarterpack.data.network.ApiInterface
import com.szymongrochowiak.androidkotlinstarterpack.data.network.NetworkRepository
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


/**
 * @author Szymon Grochowiak
 */
@Module
class NetworkingModule(private val endpoint: String) {

    companion object {
        private val CACHE_SIZE_MB = 40 * 1024 * 1024  // 40 MB
        private val CONNECTION_RETRIES = 2
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        return Cache(application.cacheDir, CACHE_SIZE_MB.toLong())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()).baseUrl(endpoint).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(localRepository: LocalRepository, retrofit: Retrofit): NetworkRepository {
        return NetworkRepository(retrofit.create<ApiInterface>(ApiInterface::class.java), CONNECTION_RETRIES)
    }
}