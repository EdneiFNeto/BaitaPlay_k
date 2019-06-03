package com.example.baitaplay_k.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.baitaplay_k.AssinaturaActivity
import com.example.baitaplay_k.LoginActivity
import com.example.baitaplay_k.R
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.tasks.UpdateuserTask
import kotlinx.android.synthetic.main.editar_user_layout.view.*

class DialogUtil {


    companion object {

        private val TAG="DialogLog"

        fun dialogNotSgnature(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Você ainda não tem assinatura\nDeseja fazer uma assinatura ?")
                .setPositiveButton("Assine agora", DialogInterface.OnClickListener { dialog, id ->
                    //send activity signature
                    context.startActivity(Intent(context, AssinaturaActivity::class.java))
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
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

        fun updateUser(context: Context, window: Window) {
            val view: View = window.decorView
            val viewCriada = LayoutInflater.from(context).inflate(R.layout.editar_user_layout, view as ViewGroup, false)
            val db = DataBaseHandler(context)

            AlertDialog.Builder(context)
                .setPositiveButton("Editar", DialogInterface.OnClickListener { dialog, which ->
                    val login = viewCriada.edt_login_dialog_perfil.text
                    val senha = viewCriada.edt_senha_dialog_perfil.text
                    var user = User(login.toString(), senha.toString(), false)
                    if(db.delete(user)){
                        db.save(user)
                        //update user in webservice
                        UpdateuserTask(context, user).execute()
                    }
                    dialog.dismiss()
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                .setTitle(R.string.update_user)
                .setView(viewCriada)
                .show()
        }
    }
}