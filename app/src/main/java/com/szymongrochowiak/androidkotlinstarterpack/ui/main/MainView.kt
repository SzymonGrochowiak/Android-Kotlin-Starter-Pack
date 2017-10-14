package com.szymongrochowiak.androidkotlinstarterpack.ui.main

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry

/**
 * @author Szymon Grochowiak
 */
interface MainView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun showContent(berry: Berry)

    fun showError(errorMessage: String)
}