package com.matt2393.kotlinmultiparadigma.Vista.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matt2393.kotlinmultiparadigma.Modelo.Entitys.Personaje
import com.matt2393.kotlinmultiparadigma.R
import com.matt2393.kotlinmultiparadigma.Tools.changeMargins
import com.matt2393.kotlinmultiparadigma.Vista.ViewHolder.PersonajeViewHolder
import kotlinx.android.synthetic.main.item_personaje.view.*

class PersonajeAdapter(var personajes: ArrayList<Personaje>, val fragmentActivity: FragmentActivity): RecyclerView.Adapter<PersonajeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder =
        PersonajeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_personaje, parent, false)
        )


    override fun getItemCount(): Int = personajes.size

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = personajes[position]

        changeMargins(pos = position, itemCount = itemCount, view = holder.itemView, fragmentActivity = fragmentActivity)

        Glide.with(fragmentActivity)
            .load(personaje.image)
            .centerCrop()
            .into(holder.itemView.image_personaje)
        holder.itemView.text_nombre_personaje.text = personaje.name
        holder.itemView.text_especie_personaje.text = personaje.species
        holder.itemView.text_estado_personaje.text = personaje.status
        holder.itemView.text_genero_personaje.text = personaje.gender
        holder.itemView.text_origen_personaje.text = personaje.origin.name
    }

}