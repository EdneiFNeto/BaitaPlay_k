package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.example.baitaplay_k.adapter.ListaCanaisAdapter
import com.example.baitaplay_k.fragments.PlayVideoFragment

class PlayVideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.framelayout_video, PlayVideoFragment())
        transaction.commit()

        findViewById<RecyclerView>(R.id.recycleview_lista_canais).apply {
            adapter = ListaCanaisAdapter()
        }

    }
}
