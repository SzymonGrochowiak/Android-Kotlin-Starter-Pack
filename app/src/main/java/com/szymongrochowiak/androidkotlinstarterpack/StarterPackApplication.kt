package com.szymongrochowiak.androidkotlinstarterpack

import android.app.Application
import com.szymongrochowiak.androidkotlinstarterpack.di.*
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

/**
 * @author Szymon Grochowiak
 */
class StarterPackApplication : Application() {

    companion object {
        private val BASE_ENDPOINT = "http://pokeapi.co/api/v2/"
    }

    lateinit var instance: StarterPackApplication
    lateinit var daggerComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimber()
        initRxJava()
        initDaggerComponent()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDaggerComponent() {
        daggerComponent = DaggerApplicationComponent.builder().applicationModule(
                ApplicationModule(this)).localDataModule(LocalDataModule()).networkingModule(
                NetworkingModule(BASE_ENDPOINT)).repositoryModule(RepositoryModule()).build()
    }

    private fun initRxJava() {
        RxJavaPlugins.setErrorHandler { throwable -> Timber.e(throwable, "RxError") }
    }

}
