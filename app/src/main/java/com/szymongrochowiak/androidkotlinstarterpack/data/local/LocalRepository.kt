package com.szymongrochowiak.androidkotlinstarterpack.data.local

import com.szymongrochowiak.androidkotlinstarterpack.data.Repository
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.objectbox.BoxStore
import io.reactivex.Observable

/**
 * @author Szymon Grochowiak
 */
class LocalRepository(val boxStore: BoxStore) : Repository {

    override fun queryBerry(id: Long) = Observable.just(Berry(id, "Test local berry"))!!
}