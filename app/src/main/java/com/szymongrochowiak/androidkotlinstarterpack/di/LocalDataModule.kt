package com.szymongrochowiak.androidkotlinstarterpack.di

import com.szymongrochowiak.androidkotlinstarterpack.data.local.LocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Szymon Grochowiak
 */
@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalRepository(): LocalRepository {
        return LocalRepository()
    }
}