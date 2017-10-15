package com.szymongrochowiak.androidkotlinstarterpack.data

import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.reactivex.Observable

/**
 * @author Szymon Grochowiak
 */
interface Repository {

    fun queryBerry(id: Long): Observable<Berry>
}