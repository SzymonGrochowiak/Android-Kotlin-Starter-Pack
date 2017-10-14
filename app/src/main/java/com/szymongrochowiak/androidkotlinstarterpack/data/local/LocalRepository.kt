package com.szymongrochowiak.androidkotlinstarterpack.data.local

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.reactivex.Observable

/**
 * @author Szymon Grochowiak
 */
class LocalRepository : Repository {

    override fun queryBerry(id: Int) = Observable.just(Berry(id, "Test local berry"))!!
}