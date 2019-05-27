package com.example.baitaplay_k

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.BundleCompat
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
    }

    override fun onResume() {
        super.onResume()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //btn_editar.setBackgroundColor(resources.getColor(R.color.primary_dark))
        }
    }
}
