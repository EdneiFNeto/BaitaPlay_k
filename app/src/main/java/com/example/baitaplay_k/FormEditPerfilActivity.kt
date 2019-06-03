package com.example.baitaplay_k

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.baitaplay_k.tasks.CheckVersionAndroidTasks
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
        if (!CheckVersionAndroidTasks.Companion.veryfyVersionHigherKitkat()) {
            edt_cadastro_email_.setBackgroundResource(R.color.colorWhite)
            edt_form_cadastro_login_.setBackgroundResource(R.color.colorWhite)
            btn_form_cadastro.setBackgroundResource(R.color.colorPrimaryDark)
        }

        Log.e(TAG, "Version higher KitKat ${Build.VERSION.SDK_INT}")
    }
}
