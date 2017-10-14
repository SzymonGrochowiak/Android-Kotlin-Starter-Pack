package com.szymongrochowiak.androidkotlinstarterpack.ui.main

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import com.szymongrochowiak.androidkotlinstarterpack.ui.common.mvp.RxPresenter
import io.reactivex.rxkotlin.subscribeBy

/**
 * @author Szymon Grochowiak
 */
class MainPresenter(private val repository: Repository) : RxPresenter<MainView>() {

    private var berry: Berry? = null
    private var errorMessage: String? = null

    fun queryBerry(berryId: Int) {
        if (restoreViewStateIfExist(berry, errorMessage)) return
        sendToView { it.showLoading() }
        val fetchBerryDisposable = repository.queryBerry(berryId).subscribeBy(onNext = { berry ->
            this.berry = berry
            sendToView { it.showContent(berry) }
        }, onError = { throwable ->
            val errorMessage = throwable.toString()
            this.errorMessage = errorMessage
            sendToView { it.showError(errorMessage) }
            sendToView { it.hideLoading() }
        }, onComplete = { sendToView { it.hideLoading() } })
        compositeDisposable.add(fetchBerryDisposable)
    }

    private fun restoreViewStateIfExist(berry: Berry?, errorMessage: String?): Boolean {
        if (berry != null) {
            sendToView({ view -> view.showContent(berry) })
            return true
        }
        if (errorMessage != null) {
            sendToView({ view -> view.showError(errorMessage) })
            return true
        }
        return false
    }
}