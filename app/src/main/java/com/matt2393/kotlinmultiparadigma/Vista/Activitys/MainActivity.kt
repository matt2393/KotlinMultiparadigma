package com.matt2393.kotlinmultiparadigma.Vista.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.Personaje
import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.ResponsePersonajes
import com.matt2393.kotlinmultiparadigma.Presentador.Presenter.PersonajePresenter
import com.matt2393.kotlinmultiparadigma.R
import com.matt2393.kotlinmultiparadigma.Vista.Adapters.PersonajeAdapter
import com.matt2393.kotlinmultiparadigma.Vista.Fragments.FragmentEjemplo
import com.matt2393.kotlinmultiparadigma.Vista.View.PersonajeView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PersonajeView{

    var adapter: PersonajeAdapter? = null
    var personajePresenter: PersonajePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personajePresenter = PersonajePresenter(personajeView = this)
        adapter = PersonajeAdapter(personajes = ArrayList(), fragmentActivity = this)
        recycler_main.layoutManager = LinearLayoutManager(this)
        recycler_main.adapter = adapter
        personajePresenter?.getPersonajes(page = 1)

        FragmentEjemplo.TAG
        FragmentEjemplo.newInstance(3)

    }


    override fun loadPersonajes(responsePersonajes: ResponsePersonajes) {

        responsePersonajes.results.associateBy ({it.id},{it})
        adapter?.personajes = responsePersonajes.results
        adapter?.notifyDataSetChanged()

    }

    override fun errorPersonajes() {
        Toast.makeText(this, "Ocurrio un error...", Toast.LENGTH_SHORT).show()
    }

    override fun show() {

    }

    override fun hide() {

    }
}
