package com.matt2393.kotlinmultiparadigma.Vista.View

import com.matt2393.kotlinmultiparadigma.LoadListener
import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.ResponsePersonajes

interface PersonajeView : LoadListener{
    fun loadPersonajes(responsePersonajes: ResponsePersonajes)
    fun errorPersonajes()
}