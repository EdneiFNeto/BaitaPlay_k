package com.example.baitaplay_k

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.baitaplay_k.adapter.ListaDeCanaisAdapter
import com.example.baitaplay_k.fragments.MainFragment
import com.example.baitaplay_k.adapter.RecycleViewCanais
import com.example.baitaplay_k.model.Canal
import com.example.baitaplay_k.util.ListaDeCanalUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private var clicouNoBotao: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar)

        val canais: List<Canal> = ListaDeCanalUtil.Companion.listaDeNavegacao()
        listview_main.adapter = ListaDeCanaisAdapter(canais, this)

        main_recycle_view.apply {
            adapter = RecycleViewCanais(ListaDeCanalUtil.Companion.listaDeCardCanais())
        }

        //go activity Person
        menu_person.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        //change icon menu click
        //changeIconMenuClick(listview_main)
        //eventClickList()
    }

    override fun onResume() {
        super.onResume()
        listview_main.visibility = View.GONE
        menu_toolbar.setImageResource(R.drawable.ic_menu)
    }

    private fun eventClickList() {
        listview_main.setOnItemClickListener { parent, view, position, id ->
            val canal: Canal = parent.getItemAtPosition(position) as Canal
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("canal", canal)
            startActivity(intent)
        }
    }

    private fun changeIconMenuClick(listaCanais: ListView) {
        menu_toolbar.setOnClickListener {
            dectedMenuCliqued()
            if (clicouNoBotao) {
                menu_toolbar.setImageResource(R.drawable.ic_close)
                listaCanais.visibility = View.VISIBLE
            } else {
                menu_toolbar.setImageResource(R.drawable.ic_menu)
                listaCanais.visibility = View.GONE
            }
        }
    }

    private fun dectedMenuCliqued() {
        clicouNoBotao = !clicouNoBotao
    }

}
