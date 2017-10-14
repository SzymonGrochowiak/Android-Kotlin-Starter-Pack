package com.szymongrochowiak.androidkotlinstarterpack.ui.main

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.di.ApplicationComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

/**
 * @author Szymon Grochowiak
 */
@Scope annotation class MainScope

@Module
class MainModule {

    @Provides
    @MainScope
    fun providePresenter(repository: Repository): MainPresenter {
        return MainPresenter(repository)
    }
}

@MainScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun presenter(): MainPresenter
}
