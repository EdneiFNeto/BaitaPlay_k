package com.example.baitaplay_k.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import com.example.baitaplay_k.FormEditPerfilActivity
import com.example.baitaplay_k.LoginActivity
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.R

class DialogAutheticationUtil {

    companion object {

        fun showDialogEditPerdon(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Usuario não tem Assinatura")
                .setPositiveButton("Assinar", DialogInterface.OnClickListener { dialog, id ->
                    context.startActivity(Intent(context, FormEditPerfilActivity::class.java))
                })

                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                    context.startActivity(Intent(context, LoginActivity::class.java))

                })
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }
    }
}