package com.szymongrochowiak.androidkotlinstarterpack.di

import android.app.Application
import com.szymongrochowiak.androidkotlinstarterpack.data.local.LocalRepository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

/**
 * @author Szymon Grochowiak
 */
@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideObjectBox(application: Application): BoxStore {
        return MyObjectBox.builder().androidContext(application).build()
    }

    @Provides
    @Singleton
    fun provideLocalRepository(boxStore: BoxStore): LocalRepository {
        return LocalRepository(boxStore)
    }
}