package com.szymongrochowiak.androidkotlinstarterpack.data.network

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.reactivex.ObservableTransformer

/**
 * @author Szymon Grochowiak
 */
class NetworkRepository(private val apiInterface: ApiInterface, private val connectionRetries: Int) : Repository {

    private fun <T> applyRequestTransformations(): ObservableTransformer<T, T> = applyTransformations(applySchedulers(),
            applyConnectionRetires(connectionRetries), applyOnErrorResumeNext()
            //applySaveLocally(mRepositoryWriter))
    )

    override fun queryBerry(id: Int) = apiInterface.getBerry(id).compose(applyRequestTransformations<Berry>())!!
}