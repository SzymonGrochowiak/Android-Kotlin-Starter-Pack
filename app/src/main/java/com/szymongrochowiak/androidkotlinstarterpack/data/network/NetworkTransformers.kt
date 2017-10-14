package com.szymongrochowiak.androidkotlinstarterpack.data.network

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.io.IOException

/**
 * @author Szymon Grochowiak
 */
fun <T> applyTransformations(vararg transformers: ObservableTransformer<T, T>): ObservableTransformer<T, T> {
    return ObservableTransformer { observable ->
        var resultObservable = observable
        for (transformer in transformers) {
            resultObservable = resultObservable.compose(transformer)
        }
        resultObservable
    }
}

fun <T> applySchedulers(): ObservableTransformer<T, T> = ObservableTransformer {
    it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> applyOnErrorResumeNext(): ObservableTransformer<T, T> = ObservableTransformer {
    it.onErrorResumeNext(Function { throwable ->
        if (throwable is IOException) Observable.empty<T>() else Observable.error<T>(throwable)
    })
}

/*
fun <T> applySaveLocally(repositoryWriter: RepositoryWriter): ObservableTransformer<T, T> {
    return { observable ->
        observable.map({ `object` ->
            val savedObject = repositoryWriter.saveToRepository(`object`)
            savedObject ?: `object`
        })
    }
}
*/

fun <T> applyConnectionRetires(connectionRetries: Int): ObservableTransformer<T, T> = ObservableTransformer {
    it.retry(connectionRetries.toLong())
}