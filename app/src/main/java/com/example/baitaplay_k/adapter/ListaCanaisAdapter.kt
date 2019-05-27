package com.example.baitaplay_k.adapter

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.R
import kotlinx.android.synthetic.main.lista_canais.view.*

class ListaCanaisAdapter :RecyclerView.Adapter<ListaCanaisAdapter.MyHolder>() {


    val titulo: List<String> = listOf("Titulo 1", "Titulo 2")
    val imagem: List<Int> = listOf(R.drawable.ic_play_circle, R.drawable.ic_play_circle)
    private  val TAG:String = "LogRecycleView"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_canais, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return titulo.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //add elemenmtos ao holder
        holder.imagemCanal.setBackgroundResource(imagem[position])
        holder.tituloCanal.text = titulo[position]

    }

    //class interna
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagemCanal: ImageView = itemView.lista_canais_imagem
        val tituloCanal: TextView = itemView.lista_canais_titulo
        val context: Context = itemView.context

    }

}
