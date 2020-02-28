package com.matt2393.kotlinmultiparadigma.Presentador.Interactor

import android.util.Log
import com.matt2393.kotlinmultiparadigma.Modelo.Retrofit.RetrofitSingleton
import com.matt2393.kotlinmultiparadigma.Presentador.Listener.PersonajeListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonajeInteractor {
    fun getPersonajes(page: Int, personajeListener: PersonajeListener){
        RetrofitSingleton.addRequest(
            RetrofitSingleton.requests!!.getPersonajes(page = page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    personajeListener.onLoad(it)
                }, {
                    personajeListener.onError()
                })
        )
    }

}