package com.matt2393.kotlinmultiparadigma.Modelo.Retrofit

import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.ResponsePersonajes
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRequest {

    @GET("api/character/?")

    fun getPersonajes(@Query("page") page: Int): Observable<ResponsePersonajes>
}