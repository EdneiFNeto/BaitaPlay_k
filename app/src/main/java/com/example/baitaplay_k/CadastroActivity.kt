package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.tasks.CheckVersionAndroidTasks
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_perfil.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    override fun onResume() {
        super.onResume()

        if(!CheckVersionAndroidTasks.Companion.veryfyVersionHigherKitkat()){

            edt_cadastro_nome.setBackgroundResource(R.color.colorWhite)
            edt_cadastro_email_.setBackgroundResource(R.color.colorWhite)
            edt_form_cadastro_login_.setBackgroundResource(R.color.colorWhite)
            edt_cadastro_email.setBackgroundResource(R.color.colorWhite)
            edt_form_cadastro_cpf.setBackgroundResource(R.color.colorWhite)
            btn_cadastrar.setBackgroundResource(R.color.primary_dark)
        }
    }


}
