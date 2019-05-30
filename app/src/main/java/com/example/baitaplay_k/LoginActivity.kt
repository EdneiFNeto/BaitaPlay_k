package com.example.baitaplay_k

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.AndroidException
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.baitaplay_k.api.INetworkAPI
import com.example.baitaplay_k.controller.LoginController
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_form_edit_perfil.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginLOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(my_toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayShowTitleEnabled(false)
        btn_entrar.setOnClickListener {
            if (!edt_login.text.isEmpty() && !edt_senha.text.isEmpty()) {
                LoginController(this).execute(edt_login.text.toString(), edt_senha.text.toString())
            }else{
                Toast.makeText(this, "Preencha todos os campo", Toast.LENGTH_SHORT).show()
            }
        }

        text_cadastrar.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        mudarCorAndroidVersion19(edt_login, edt_senha)
    }

    private fun mudarCorAndroidVersion19(login: EditText, senha: EditText) {
        if (Build.VERSION.SDK_INT <= 19) {
            login.setBackgroundColor(Color.WHITE)
            senha.setBackgroundColor(Color.WHITE)
            btn_entrar.setBackgroundResource(R.color.primary_dark)
        }
    }

}
