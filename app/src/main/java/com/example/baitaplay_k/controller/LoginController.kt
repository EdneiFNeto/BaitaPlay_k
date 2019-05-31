package com.example.baitaplay_k.controller

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Handler
import android.util.Log
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.DialogUtil
import org.json.JSONArray
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class LoginController(context: Context) : AsyncTask<String, String, String>() {

    private val TAG: String = "LoginLog"
    private var login: String? = null
    private var senha: String? = null
    private val context: Context = context

    override fun doInBackground(vararg params: String?): String {

        login = params[0]
        senha = params[1]

        val connection = URL("http://192.168.43.124/dev/API/login/").openConnection() as HttpURLConnection
        //val connection = URL("http://192.168.0.28/dev/API/login/").openConnection() as HttpURLConnection
        var text: String = ""

        try {
            connection.connect()
            text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "Error ${e.message}")
        }

        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        val lista: List<User> = handler(result)

        try {
            if (lista.isNotEmpty() || lista.size <= 0) {
                for (user: User in lista) {
                    if (login == user.login && senha == user.senha) {
                        //save user database
                        context.startActivity(Intent(context, MainActivity::class.java))
                    } else {
                        DialogUtil.Companion.userNotauthorized(context)
                    }
                }
            } else {
                Handler().post(Runnable {
                    DialogUtil.Companion.errorServer(context)
                })
            }
        } catch (e: Exception) {
            Handler().post(Runnable {
                DialogUtil.Companion.errorServer(context)
            })
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
            val senha = jsonObject.getString("senha")
            list.add(User(login, senha, false))
            x++
        }

        return list
    }

}