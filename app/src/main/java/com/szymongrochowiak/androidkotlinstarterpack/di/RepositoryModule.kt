package com.szymongrochowiak.androidkotlinstarterpack.di

import com.szymongrochowiak.androidkotlinstarterpack.data.ApplicationRepository
import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.local.LocalRepository
import com.szymongrochowiak.androidkotlinstarterpack.data.network.NetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Szymon Grochowiak
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideApplicationRepository(networkRepository: NetworkRepository,
                                     localRepository: LocalRepository): Repository {
        return ApplicationRepository(listOf(networkRepository, localRepository))
    }
}
