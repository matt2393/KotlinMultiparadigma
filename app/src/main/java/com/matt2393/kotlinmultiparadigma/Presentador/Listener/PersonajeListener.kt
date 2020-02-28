package com.matt2393.kotlinmultiparadigma.Presentador.Listener

import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.ResponsePersonajes

interface PersonajeListener {
    fun onLoad(responsePersonajes: ResponsePersonajes)
    fun onError()
}