package com.example.baitaplay_k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.R
import com.example.baitaplay_k.model.Canal

class ListaDeCanaisAdapter(canais: List<Canal>, context:Context): BaseAdapter() {

    private val context = context
    private val canais:List<Canal>  = canais

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(context).inflate(R.layout.lista_canais, parent, false)
        val imagem = view.findViewById<ImageView>(R.id.lista_canais_imagem)
        val titulo = view.findViewById<TextView>(R.id.lista_canais_titulo)

        imagem.setImageResource(canais[position].imagem)
        titulo.text = canais[position].titulo

        return view
    }

    override fun getItem(position: Int): Any{
        return canais[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return canais.size
    }
}