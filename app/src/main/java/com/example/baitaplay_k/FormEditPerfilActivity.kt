package com.example.baitaplay_k

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.baitaplay_k.util.CheckVersionAndroidUtil
import kotlinx.android.synthetic.main.activity_form_edit_perfil.*

class FormEditPerfilActivity : AppCompatActivity() {

    val TAG: String = "FormLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_edit_perfil)
    }


    override fun onResume() {
        super.onResume()

        //verify version higher Kitkat
        if (!CheckVersionAndroidUtil.Companion.veryfyVersionHigherKitkat()) {
            edt_cadastro_login.setBackgroundResource(R.color.colorWhite)
            edt_form_cadastro_senha.setBackgroundResource(R.color.colorWhite)
            btn_form_cadastro.setBackgroundResource(R.color.colorPrimaryDark)
        }

        Log.e(TAG, "Version higher KitKat ${Build.VERSION.SDK_INT}")
    }
}
