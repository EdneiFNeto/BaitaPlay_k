package com.example.baitaplay_k.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.R
import com.example.baitaplay_k.model.Canal
import kotlinx.android.synthetic.main.lista_canais.view.*

class ListaCanaisRecycleViewAdapter(canais:List<Canal>) :RecyclerView.Adapter<ListaCanaisRecycleViewAdapter.MyHolder>() {

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
