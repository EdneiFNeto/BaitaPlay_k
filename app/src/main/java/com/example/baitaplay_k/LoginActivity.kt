package com.example.baitaplay_k

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginLOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(my_toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayShowTitleEnabled(false)


        val login = findViewById<EditText>(R.id.edt_login)
        val senha = findViewById<EditText>(R.id.edt_senha)

        btn_entrar.setOnClickListener {
            if (!login.text.isEmpty() && !senha.text.isEmpty()) {
                if (login.text.toString() == "admin" && senha.text.toString() == "123456") {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Log.e(TAG, "Usuario invalido")
                }
            } else {
                Log.e(TAG, "*Preencha todos os campo")
            }

            Log.e(TAG, "Login ${login.text}\nSenha ${senha.text}")
        }

        mudarCorAndroidVersion19(login, senha)

    }

    private fun mudarCorAndroidVersion19(login: EditText, senha: EditText) {
        if (Build.VERSION.SDK_INT <= 19) {
            login.setBackgroundColor(Color.WHITE)
            senha.setBackgroundColor(Color.WHITE)
            btn_entrar.setBackgroundResource(R.color.primary_dark)
        }
    }

}
