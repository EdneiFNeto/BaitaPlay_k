package com.example.baitaplay_k

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.*
import com.example.baitaplay_k.adapter.ListaCanaisAdapter
import com.example.baitaplay_k.adapter.ListaDeCanaisAdapter
import com.example.baitaplay_k.fragments.PlayVideoFragment
import com.example.baitaplay_k.model.Canal
import kotlinx.android.synthetic.main.activity_play_video.*
import kotlinx.android.synthetic.main.play_video_fragement.*
import kotlinx.android.synthetic.main.toolbar.*


class PlayVideoActivity : AppCompatActivity() {


    private var clicouNoBotao: Boolean = false
    private lateinit var listaAdapter: ListaCanaisAdapter
    private var urlCanal:String = "http://189.45.13.225/stream.php.m3u8?user=baita&pass=2018tv&token=1553733132&resptime=109&s=stream"
    private val TAG:String = "PlayVideoLOG"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        setSupportActionBar(my_toolbar)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.framelayout_video, PlayVideoFragment())
        transaction.commit()

        val canais: List<Canal> = getLista()
        val adapter = ListaDeCanaisAdapter(canais, this)
        val menuToolbar = findViewById<ImageView>(R.id.menu_toolbar)

        listview_canais.adapter = adapter
        tocarVideoClick()


        menu_person.setOnClickListener{
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        exibirListaDeCanais(menuToolbar)
    }

    private fun tocarVideoClick() {
        listview_canais.setOnItemClickListener { parent, view, position, id ->
            clicouNoBotao = !clicouNoBotao
            listview_canais.visibility = View.GONE
            menu_toolbar.setImageResource(R.drawable.ic_menu)

            //play
            val canal: Canal = parent.getItemAtPosition(position) as Canal
            playVideo(position, canal)
        }
    }

    private fun playVideo(position: Int, canal: Canal) {

        var url:String = ""

        val menu = when (position) {
            0 ->url = urlCanal + "39.m3u8"//bora films
            1 ->url = urlCanal + "41.m3u8"//clubinho
            2 ->url = urlCanal + "27.m3u8"//rede mosaico
            3 ->url = urlCanal + "42.m3u8"//up channel
            4 ->url = urlCanal + "37.m3u8"//entreter
            5 ->url = urlCanal + "31.m3u8"//life
            6 -> url = urlCanal + "44.m3u8"//hello tv
            7 ->url = urlCanal +"28.m3u8"//full music
            8 ->url = urlCanal + "35.m3u8"//you channel
            9 ->url = urlCanal + "36.m3u8"//canal promessa
            10 ->url = urlCanal + "29.m3u8"//24h news
            else -> "Nao existe canal"
        }

        play(url)
        Log.e(TAG, "Canal: $url")
        play_video_titulo.text = canal.titulo

    }

    private fun play(url: String) {
        val n:String ="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
        play_video_videoview.setVideoURI(Uri.parse(n))
        //progressbar.visibility = View.VISIBLE
        play_video_videoview.start()

    }

    private fun exibirListaDeCanais(menuToolbar: ImageView) {
        menuToolbar.setOnClickListener {

            clicouNoBotao = !clicouNoBotao

            if (clicouNoBotao) {
                menuToolbar.setImageResource(R.drawable.ic_close)
                listview_canais.visibility = View.VISIBLE
            } else {
                menuToolbar.setImageResource(R.drawable.ic_menu)
                listview_canais.visibility = View.GONE
            }
        }
    }

    fun getLista(): List<Canal> {

        return listOf(

            Canal("Bora Filmes", R.mipmap.ic_bora_filmes,""),
            Canal("Clubinho Play", R.mipmap.ic_clubinho,""),
            Canal("Rede Mosaico", R.mipmap.ic_mosaico,""),
            Canal("Up Cahnnel", R.mipmap.ic_up_channel,""),
            Canal("Entreter", R.mipmap.ic_entreter, ""),
            Canal("Life Channel", R.mipmap.ic_life_channel, ""),
            Canal("hello TV", R.mipmap.ic_hello_tv, ""),
            Canal("Full Music", R.mipmap.ic_full_music, ""),
            Canal("You Channel", R.mipmap.ic_yu_channel,""),
            Canal("Canal Promessas", R.mipmap.ic_canal_promessas,""),
            Canal("24h Noews", R.mipmap.ic_24h_new,"")
        )
    }

}
