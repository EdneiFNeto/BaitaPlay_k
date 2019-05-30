package com.example.baitaplay_k.controller

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.model.User
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class LoginController(context: Context) : AsyncTask<String, String, String>() {

    private val TAG: String = "LoginLog"
    private var login: String? = null
    private var senha: String? = null
    private val context:Context = context

    override fun doInBackground(vararg params: String?): String {

        login = params[0]
        senha = params[1]

        val connection = URL("http://192.168.0.28/dev/API/login/").openConnection() as HttpURLConnection
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
            for (user:User in lista){
                if(login == user.login && senha == user.senha){
                    //save user database
                    context.startActivity(Intent(context, MainActivity::class.java))
                    break
                }else{
                    Toast.makeText(context, "Usuario invalido ", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun handler(result: String?):List<User> {
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

    override fun onPreExecute() {
        super.onPreExecute()
    }
}