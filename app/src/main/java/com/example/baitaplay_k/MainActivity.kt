package com.example.baitaplay_k

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import com.example.baitaplay_k.adapter.RecycleViewCanais
import com.example.baitaplay_k.tasks.AuthentuicationUserTasks
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.ListaDeCanalUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private var clicouNoBotao: Boolean = false
    private val TAG: String ="MainLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar)

        main_recycle_view.apply {
            adapter = RecycleViewCanais(ListaDeCanalUtil.Companion.listaDeCardCanais())
        }

        //go activity Person
        menu_person.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        menu_logout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        var login: String? = null
        var senha: String? = null

        val db = DataBaseHandler(this)
        var cursor: Cursor = db.select()

        if (cursor != null) {
            while (cursor.moveToNext()) {
                login = cursor.getString(cursor.getColumnIndex("login"))
                senha = cursor.getString(cursor.getColumnIndex("senha"))
                Log.e(TAG, "Users $login\n$senha")
            }
        }

        //verify status payment user
        AuthentuicationUserTasks(this, User(login.toString(), senha.toString(), false)).execute()
        menu_toolbar.setImageResource(R.drawable.ic_menu)
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
