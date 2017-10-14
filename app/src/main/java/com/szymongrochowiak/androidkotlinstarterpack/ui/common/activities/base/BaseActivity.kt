package com.szymongrochowiak.androidkotlinstarterpack.ui.common.activities.base

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.szymongrochowiak.androidkotlinstarterpack.StarterPackApplication

/**
 * @author Szymon Grochowiak
 */
abstract class BaseActivity<V : MvpView, P : MvpBasePresenter<V>> : MvpActivity<V, P>() {

    protected abstract fun injectDependencies()

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    protected fun getDaggerApplicationComponent() = (application as StarterPackApplication).daggerComponent
}