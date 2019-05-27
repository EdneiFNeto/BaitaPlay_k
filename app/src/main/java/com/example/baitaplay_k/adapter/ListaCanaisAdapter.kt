package com.example.baitaplay_k.adapter

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.PlayVideoActivity
import com.example.baitaplay_k.R
import com.example.baitaplay_k.model.Canal
import kotlinx.android.synthetic.main.lista_canais.view.*

class ListaCanaisAdapter(canais:List<Canal>) :RecyclerView.Adapter<ListaCanaisAdapter.MyHolder>() {

    val canais: List<Canal> = canais

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lista_canais, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return canais.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val canal = canais[position]
        holder.imagemCanal.setImageResource(canal.imagem)
        holder.tituloCanal.text = canal.titulo

        holder.itemView.setOnClickListener{
            //Intent(Intent.ACTION_VIEW, )
        }
    }

    //class interna
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagemCanal: ImageView = itemView.lista_canais_imagem
        val tituloCanal: TextView = itemView.lista_canais_titulo

    }

}
