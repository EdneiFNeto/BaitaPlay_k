package com.example.baitaplay_k.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.baitaplay_k.R
import com.example.baitaplay_k.VideoActivity
import com.example.baitaplay_k.model.Canal
import kotlinx.android.synthetic.main.item_canais.view.*


class RecycleViewCanais(canais:List<Canal>): RecyclerView.Adapter<RecycleViewCanais.MyHolder>() {

    val canais:List<Canal> = canais
    private  val TAG:String = "LogRecycleView"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_canais, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return canais.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val canal = canais[position]
        holder.imagemCanal.setBackgroundResource(canal.imagem)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, VideoActivity::class.java)
            intent.putExtra("canal", canal)
            holder.itemView.context.startActivity(intent)
        }
    }

    //class interna
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagemCanal:ImageView = itemView.main_imagem_canais
        val context:Context = itemView.context


    }

}
