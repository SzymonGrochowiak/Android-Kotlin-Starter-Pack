package com.szymongrochowiak.androidkotlinstarterpack.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Szymon Grochowiak
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @Singleton
    fun providesStarterPackApplication(): Application {
        return mApplication
    }
}
