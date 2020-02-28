package com.matt2393.kotlinmultiparadigma.Presentador.Presenter

import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.ResponsePersonajes
import com.matt2393.kotlinmultiparadigma.Presentador.Interactor.PersonajeInteractor
import com.matt2393.kotlinmultiparadigma.Presentador.Listener.PersonajeListener
import com.matt2393.kotlinmultiparadigma.Vista.View.PersonajeView

class PersonajePresenter(val personajeView: PersonajeView) : PersonajeListener{
    val personajeInteractor = PersonajeInteractor()

    fun getPersonajes(page: Int){
        personajeView.show()
        personajeInteractor.getPersonajes(page = page, personajeListener = this)
    }

    override fun onLoad(responsePersonajes: ResponsePersonajes) {
        personajeView.hide()
        personajeView.loadPersonajes(responsePersonajes = responsePersonajes)
    }

    override fun onError() {
        personajeView.hide()
        personajeView.errorPersonajes()
    }
}