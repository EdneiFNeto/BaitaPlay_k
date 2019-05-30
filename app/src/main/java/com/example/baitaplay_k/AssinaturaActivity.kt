package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_assinatura.*
import java.net.URLEncoder

class AssinaturaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assinatura)
    }

    override fun onResume() {
        super.onResume()


        //web_view_assinatura.loadUrl("https://divertenet.com.br/baitaplay/login_mobile.php")
        web_view_assinatura.settings.javaScriptEnabled = true
        web_view_assinatura.loadUrl("https://pagamentos.nbtelecom.com.br/pagina_checkout_baitaplay_mobile.php?login=ednei")

    }
}
