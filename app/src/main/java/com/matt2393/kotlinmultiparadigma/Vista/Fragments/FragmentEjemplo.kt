package com.matt2393.kotlinmultiparadigma.Vista.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class FragmentEjemplo: Fragment() {
    val TAG1="dsada"
    companion object{
        const val TAG="FragmentEjemplo"
        const val DATO ="DAto"
        fun newInstance(dato: Int): FragmentEjemplo{
            val bn = Bundle()
            bn.putInt(DATO, dato)
            val fr= FragmentEjemplo()
            fr.arguments = bn
            return fr
        }
    }

}