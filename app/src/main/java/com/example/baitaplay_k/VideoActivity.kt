package com.example.baitaplay_k

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import com.example.baitaplay_k.adapter.ListaDeCanaisAdapter
import com.example.baitaplay_k.model.Canal
import com.example.baitaplay_k.model.NomeCanal
import com.example.baitaplay_k.util.ListaDeCanalUtil
import kotlinx.android.synthetic.main.activity_play_video.*
import kotlinx.android.synthetic.main.toolbar.*


class VideoActivity : AppCompatActivity() {

    private var clicouNoBotao: Boolean = false
    private val TAG: String = "PlayVideoLOG"
    private var strCanal: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        val listaCanais = findViewById<ListView>(R.id.list_view_canais)

        setSupportActionBar(my_toolbar)

        //go activity Person
        menu_person.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        //change icon menu click
        changeIconMenuClick(listaCanais)
        listaCanais.adapter = ListaDeCanaisAdapter(ListaDeCanalUtil.Companion.listaDeNavegacao(), this)

        listaCanais.setOnItemClickListener { parent, view, position, id ->
            val canal: Canal = parent.getItemAtPosition(position) as Canal
            playVideoUsingClickList(position, canal)
        }
    }

    override fun onResume() {
        super.onResume()

        val canal: Canal = intent.extras.get("canal") as Canal

        if (canal != null) {

            text_titulo_canal.text = canal.titulo
            text_descr_video.text = canal.descr
            strCanal = getNameCanal(canal)

        } else {
            strCanal = "39.m3u8" //default
        }

        //play channel when start activity
        play(strCanal)

    }

    private fun getNameCanal(canal: Canal): String {

        var stringCanal = ""

        if (canal.titulo == NomeCanal.BORA_FILMES.nome) {
            stringCanal = "39.m3u8"
        }

        if (canal.titulo == NomeCanal.CLUBINHO.nome) {
            stringCanal = "41.m3u8"
        }

        if (canal.titulo == NomeCanal.REDE_MOSAICO.nome) {
            stringCanal = "27.m3u8"
        }

        if (canal.titulo == NomeCanal.UP_CHANNEL.nome) {
            stringCanal = "42.m3u8"
        }

        if (canal.titulo == NomeCanal.ENTRETER.nome) {
            stringCanal = "37.m3u8"
        }

        if (canal.titulo == NomeCanal.LIFE_CHANNEL.nome) {
            stringCanal = "31.m3u8"
        }

        if (canal.titulo == NomeCanal.HELLO_TV.nome) {
            stringCanal = "44.m3u8"
        }

        if (canal.titulo == NomeCanal.FULL_MUSIC.nome) {
            stringCanal = "28.m3u8"
        }

        if (canal.titulo == NomeCanal.YOU_CHANNEL.nome) {
            stringCanal = "35.m3u8"
        }

        if (canal.titulo == NomeCanal.CANAL_PROMESSA.nome) {
            stringCanal = "36.m3u8"
        }

        if (canal.titulo == NomeCanal.CANAL_24HS.nome) {
            stringCanal = "29.m3u8"
        }

        return stringCanal

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

    //play video using click list
    private fun playVideoUsingClickList(position: Int, canal: Canal) {

        var strCanal: String = ""

        val menu = when (position) {

            0 -> strCanal = "39.m3u8"//bora films
            1 -> strCanal = "41.m3u8"//clubinho
            2 -> strCanal = "27.m3u8"//rede mosaico
            3 -> strCanal = "42.m3u8"//up channel
            4 -> strCanal = "37.m3u8"//entreter
            5 -> strCanal = "31.m3u8"//life
            6 -> strCanal = "44.m3u8"//hello tv
            7 -> strCanal = "28.m3u8"//full music
            8 -> strCanal = "35.m3u8"//you channel
            9 -> strCanal = "36.m3u8"//canal promessa
            10 -> strCanal ="29.m3u8"//24h news

            else -> "Nao existe canal"
        }

        text_titulo_canal.text = canal.titulo
        dectedMenuCliqued()
        list_view_canais.visibility = View.GONE
        menu_toolbar.setImageResource(R.drawable.ic_menu)

        //play channel
        play(strCanal)

    }

    private fun dectedMenuCliqued() {
        clicouNoBotao = !clicouNoBotao
    }

    //play canal
    private fun play(canal: String) {

        val streamUrl="http://189.45.13.225/stream.php.m3u8?user=baita&pass=2018tv&token=1553733132&resptime=109&s=stream"
        video_view.setVideoURI(Uri.parse(streamUrl+""+canal))
        video_view.start()

        Log.e(TAG, "Stream URL: $streamUrl$canal")
    }

}
