package com.szymongrochowiak.androidkotlinstarterpack.data.network

import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Szymon Grochowiak
 */
interface ApiInterface {

    @GET("berry/{id}")
    fun getBerry(@Path("id") id: Int): Observable<Berry>
}