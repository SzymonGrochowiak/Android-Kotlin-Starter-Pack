package com.szymongrochowiak.androidkotlinstarterpack.ui.common.mvp

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Szymon Grochowiak
 */
open class RxPresenter<V : MvpView> : MvpBasePresenter<V>() {

    val compositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        if (!retainInstance) {
            compositeDisposable.dispose()
        }
    }

    fun sendToView(viewAction: (view: V) -> Unit) {
        if (isViewAttached) viewAction(view)
    }
}
