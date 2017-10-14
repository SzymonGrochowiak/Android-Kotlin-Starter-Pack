package com.szymongrochowiak.androidkotlinstarterpack.ui.common.fragments.base

import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * @author Szymon Grochowiak
 */
abstract class BaseFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>()
