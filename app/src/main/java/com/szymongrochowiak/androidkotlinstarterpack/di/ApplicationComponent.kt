package com.szymongrochowiak.androidkotlinstarterpack.di

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import dagger.Component
import javax.inject.Singleton

/**
 * @author Szymon Grochowiak
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, LocalDataModule::class, NetworkingModule::class,
        RepositoryModule::class))
interface ApplicationComponent {

    fun repository(): Repository
}