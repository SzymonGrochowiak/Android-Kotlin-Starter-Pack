package com.szymongrochowiak.androidkotlinstarterpack.ui.common.dialogs.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback

/**
 * @author Szymon Grochowiak
 */
abstract class BaseDialogFragment<V : MvpView, P : MvpPresenter<V>> : DialogFragment(), MvpDelegateCallback<V, P> {

    private val mMvpDelegate = FragmentMvpDelegateImpl(this, this, true, true)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mMvpDelegate.onAttach(context as Activity?)
    }

    override fun onDetach() {
        super.onDetach()
        mMvpDelegate.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMvpDelegate.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mMvpDelegate.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMvpDelegate.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mMvpDelegate.onStart()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        mMvpDelegate.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        mMvpDelegate.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMvpDelegate.onPause()
    }

    override fun onStop() {
        super.onStop()
        mMvpDelegate.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMvpDelegate.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMvpDelegate.onDestroy()
    }
}
