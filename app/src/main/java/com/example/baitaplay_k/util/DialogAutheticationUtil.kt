package com.example.baitaplay_k.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import com.example.baitaplay_k.AssinaturaActivity
import com.example.baitaplay_k.FormEditPerfilActivity
import com.example.baitaplay_k.LoginActivity
import com.example.baitaplay_k.R

class DialogAutheticationUtil {

    companion object {

        fun showDialog(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Você ainda não tem assinatura\nDeseja fazer uma assinatura ?")
                .setPositiveButton("Assine agora", DialogInterface.OnClickListener { dialog, id ->
                    context.startActivity(Intent(context, AssinaturaActivity::class.java))
                })
                .setCancelable(false)
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }
    }
}