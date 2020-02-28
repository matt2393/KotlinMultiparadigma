package com.matt2393.kotlinmultiparadigma.Modelo.Retrofit


import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.matt2393.kotlinmultiparadigma.Tools.URL
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/// Object es considerado un Singleton en Kotlin
object RetrofitSingleton {
    var disposable: CompositeDisposable? = null
    var requests: RetrofitRequest? = null
    var retrofit: Retrofit? = null

    init {
        disposable= CompositeDisposable()
        retrofit= Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        requests= retrofit?.create(RetrofitRequest::class.java)
    }

    fun addRequest(d: Disposable){
        disposable?.add(d)
    }
}