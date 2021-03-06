package com.example.baitaplay_k

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.baitaplay_k.tasks.CheckVersionAndroidTasks
import com.example.baitaplay_k.tasks.LoginUserTasks
import com.example.baitaplay_k.util.CheckConnectionUtil
import com.example.baitaplay_k.util.DialogUtil
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

        btn_entrar.setOnClickListener {
            if (!edt_login.text.isEmpty() && !edt_senha.text.isEmpty()) {
                if(CheckConnectionUtil.isNetworkAvailable(this)){
                    LoginUserTasks(
                        this,
                        edt_login.text.toString(),
                        edt_senha.text.toString()
                    ).execute()
                }else{
                    DialogUtil.dialogNetworks(this)
                }
            }else{
                DialogUtil.Companion.showDialogEmptyField(this)
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
        if (!CheckVersionAndroidTasks.Companion.veryfyVersionHigherKitkat()) {
            login.setBackgroundColor(Color.WHITE)
            senha.setBackgroundColor(Color.WHITE)
            btn_entrar.setBackgroundResource(R.color.primary_dark)
        }
    }

}
