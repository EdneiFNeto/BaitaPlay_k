package com.example.baitaplay_k.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.baitaplay_k.R
import com.example.baitaplay_k.adapter.ListaDeCanaisAdapter
import com.example.baitaplay_k.model.Canal
import com.example.baitaplay_k.util.ListaDeCanalUtil
import kotlinx.android.synthetic.main.toolbar.view.*

class ListaCanaisFragment : Fragment() {

    private var clicouNoBotao: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.lista_nav_canais, container, false)
        val listaCanais = view.findViewById<ListView>(R.id.lista_nav_canais)
        val canais = ListaDeCanalUtil.Companion.listaDeNavegacao()

        listaCanais.adapter = ListaDeCanaisAdapter(canais, view.context)


        listaCanais.setOnItemClickListener { parent, view, position, id ->

            clicouNoBotao = !clicouNoBotao

            //listview_canais.visibility = View.GONE
           //view.menu_toolbar.setImageResource(R.drawable.ic_menu)

            //play
            val canal: Canal = parent.getItemAtPosition(position) as Canal

        }

        return view
    }
}
