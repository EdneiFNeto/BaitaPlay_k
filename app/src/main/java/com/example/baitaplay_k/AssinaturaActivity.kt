package com.example.baitaplay_k

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.dao.UserDao
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.tasks.VerifyUserSubscriTasks
import kotlinx.android.synthetic.main.activity_assinatura.*

class AssinaturaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assinatura)
    }

    override fun onResume() {
        super.onResume()

        var login:String?=null
        var senha:String?=null

        val db = DataBaseHandler(this)
        var cursor: Cursor = db.select()

        if (cursor != null) {
            while (cursor.moveToNext()) {
                login = cursor.getString(cursor.getColumnIndex("login")).toUpperCase()
                senha = cursor.getString(cursor.getColumnIndex("senha")).toUpperCase()
            }
        }

        //verify user is subscribe
        VerifyUserSubscriTasks(this, login.toString(), senha.toString()).execute()

        web_view_assinatura.settings.javaScriptEnabled = true
        web_view_assinatura.loadUrl("https://pagamentos.nbtelecom.com.br/checkout_baitaplay_mobile.php?login=ednei")

    }
}
