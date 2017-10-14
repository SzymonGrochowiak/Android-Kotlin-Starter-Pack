package com.szymongrochowiak.androidkotlinstarterpack.data

import io.reactivex.Observable

/**
 * @author Szymon Grochowiak
 */
class ApplicationRepository(private val repositoriesPriority: List<Repository>) : Repository {

    override fun queryBerry(id: Int) = Observable.fromIterable(repositoriesPriority).concatMap {
        it.queryBerry(id)
    }.take(1)!!
}