package com.example.baitaplay_k.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AlertDialog
import com.example.baitaplay_k.FormEditPerfilActivity
import com.example.baitaplay_k.R

class ShowDialogEditPersonUtil {

    companion object {

        fun showDialogEditPerdon(context:Context){
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Gostaria de Editar seu perfil?")
                .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, id ->
                    context.startActivity(Intent(context, FormEditPerfilActivity::class.java))
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()


        }
    }
}