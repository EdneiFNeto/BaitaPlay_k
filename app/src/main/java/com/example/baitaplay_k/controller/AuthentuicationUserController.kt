package com.example.baitaplay_k.controller

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.DialogAutheticationUtil
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class AuthentuicationUserController(context: Context): AsyncTask<String, String, String>() {

    private val context: Context = context

    private var login: String? = null
    private var senha: String? = null
    private val TAG: String?="SubiscrobeLog"

    override fun doInBackground(vararg params: String?): String {

        //saving parameter get activity
        login = params[0]
        senha = params[1]

        val connection = URL("https://divertenet.com.br/utils/controll/vrifyUserIsSubscriber.php?login=$login&senha=$senha")
                .openConnection() as HttpURLConnection

        var text: String = ""

        try {

            connection.connect()
            text = connection.inputStream.use { it.reader().use { reader -> reader.readText()}}

        } finally {

        }

        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        val lista:List<User> = handler(result)

        if(lista.isNotEmpty()){
            for (user: User in lista){

                //verify users exists and isPaid == true
                if(user.login == login && user.isPaid){
                    //save user database
                    Toast.makeText(context, "Usuario Autenticado", Toast.LENGTH_LONG).show()
                    Log.e(TAG, "Usuario ${user.login} esta autenticado ${user.isPaid}")
                }else{
                    DialogAutheticationUtil.Companion.showDialog(context)
                }
            }
        }
    }

    private fun handler(result: String?): List<User> {

        val jsonArray = JSONArray(result)
        val list = ArrayList<User>()
        var x: Int = 0
        while (x < jsonArray.length()) {

            val jsonObject = jsonArray.getJSONObject(x)
            Log.e(TAG, "Objetos ${jsonObject.toString()}")

            val login = jsonObject.getString("login")
            val isPaid = jsonObject.getBoolean("is_paid")

            list.add(User(login, "", isPaid))

            x++
        }

        return list

    }
}