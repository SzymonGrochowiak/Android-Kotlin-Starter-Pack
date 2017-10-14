package com.szymongrochowiak.androidkotlinstarterpack.data.network

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.reactivex.Observable

/**
 * @author Szymon Grochowiak
 */
class NetworkRepository : Repository {

    override fun queryBerry(id: Int) = Observable.just(Berry(id, "Test network berry"))!!
}