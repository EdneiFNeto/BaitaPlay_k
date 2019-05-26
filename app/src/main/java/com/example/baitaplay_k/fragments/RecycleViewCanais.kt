package com.example.baitaplay_k.fragments

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.R


class RecycleViewCanais(): RecyclerView.Adapter<RecycleViewCanais.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_canais, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: RecycleViewCanais.MyHolder, position: Int) {
        //add elemenmtos ao holder
        holder.add()
    }

    //class interna
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagemCanal = itemView.findViewById<ImageView>(R.id.main_imagem_canais)
        val botaoPlayCanal = itemView.findViewById<Button>(R.id.main_botao_canais)
        val tituloCanal = itemView.findViewById<TextView>(R.id.main_titulo_canais)

        fun  add(){
            imagemCanal.setImageResource(R.drawable.banner_flash)
            tituloCanal.text = "1° Temporada do Flash"
        }
    }

}
