package com.example.baitaplay_k.adapter

import android.content.Context
import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.baitaplay_k.PlayVideoActivity
import com.example.baitaplay_k.R
import kotlinx.android.synthetic.main.item_canais.view.*


class RecycleViewCanais(): RecyclerView.Adapter<RecycleViewCanais.MyHolder>() {


    val titulo: List<String> = listOf("Titulo 1", "Titulo 2")
    val imagem: List<Int> = listOf(R.drawable.banner_flash, R.drawable.banner_flash)
    private  val TAG:String = "LogRecycleView"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_canais, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return titulo.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //add elemenmtos ao holder
        holder.imagemCanal.setBackgroundResource(imagem[position])
        holder.tituloCanal.text = titulo[position]
        holder.button.setOnClickListener{
            val intent = Intent(holder.context, PlayVideoActivity::class.java)
            holder.context.startActivity(intent)
        }
    }



    //class interna
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagemCanal:ImageView = itemView.main_imagem_canais
        val tituloCanal:TextView  = itemView.main_titulo_canais
        val button: FloatingActionButton = itemView.main_botao_canais
        val context:Context = itemView.context


    }

}
