package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.dao.UserDao
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.VerifyUserSubscriUtil
import kotlinx.android.synthetic.main.activity_assinatura.*
import java.net.URLEncoder

class AssinaturaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assinatura)
    }

    override fun onResume() {
        super.onResume()

        val dao:List<User> = UserDao.getUser()

        val login:String = dao[0].login
        val senha:String = dao[0].senha

        //verify user is subscribe
        VerifyUserSubscriUtil(this, login, senha).execute()

        web_view_assinatura.settings.javaScriptEnabled = true
        web_view_assinatura.loadUrl("https://pagamentos.nbtelecom.com.br/checkout_baitaplay_mobile.php?login=ednei")

    }
}
