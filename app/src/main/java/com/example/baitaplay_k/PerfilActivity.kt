package com.example.baitaplay_k

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.util.DialogUtil
import com.example.baitaplay_k.util.ShowDialogEditPersonUtil
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        atualizar()
    }

    override fun onResume() {
        super.onResume()
        atualizar()
        btn_editar.setOnClickListener {
            DialogUtil.Companion.updateUser(this, window)
        }
    }

    fun atualizar(){
        val db = DataBaseHandler(this)
        var cursor: Cursor = db.select()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val login = cursor.getString(cursor.getColumnIndex("login")).toUpperCase()
                text_login_perfil.text = login
            }
        } else {
            text_login_perfil.text = "Nome nãoi cadastrad"
        }
    }
}
