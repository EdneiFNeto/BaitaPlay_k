package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.util.DialogUtil
import com.example.baitaplay_k.util.ShowDialogEditPersonUtil
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        //show modal
        btn_editar.setOnClickListener{
            //ShowDialogEditPersonUtil.Companion.showDialogEditPerdon(this)
            DialogUtil.Companion.updateUser(this, window)
        }
    }

    override fun onResume() {
        super.onResume()


    }
}
