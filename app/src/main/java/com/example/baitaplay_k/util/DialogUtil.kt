package com.example.baitaplay_k.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import com.example.baitaplay_k.AssinaturaActivity
import com.example.baitaplay_k.FormEditPerfilActivity
import com.example.baitaplay_k.LoginActivity
import com.example.baitaplay_k.R

class DialogUtil {

    companion object {

        fun showDialog(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Você ainda não tem assinatura\nDeseja fazer uma assinatura ?")
                .setPositiveButton("Assine agora", DialogInterface.OnClickListener { dialog, id ->
                    //send activity signature
                    context.startActivity(Intent(context, AssinaturaActivity::class.java))
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener{dialog, id->
                    //return login
                    context.startActivity(Intent(context, LoginActivity::class.java))
                })
                .setCancelable(false)
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }

        fun showDialogEmptyField(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Preencha todos os campo !")
                .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }

        fun userNotauthorized(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Usuário não autorizado, tente novamente!")
                .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }

        fun errorServer(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Falha de conexão, verifique se esta conectado\nou tente novamente mais tarde. ")
                .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
                .setIcon(R.drawable.ic_info)

            val alert = builder.create()
            alert.setTitle("Aviso")
            alert.show()
        }
    }
}