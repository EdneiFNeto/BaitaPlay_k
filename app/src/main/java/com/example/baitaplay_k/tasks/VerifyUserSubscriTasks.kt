package com.example.baitaplay_k.tasks

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.model.User
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class VerifyUserSubscriTasks(context: Context, login:String, senha:String): AsyncTask<String, String, String>() {

    private val login: String = login
    private val senha: String = senha
    private val context: Context = context
    private val TAG: String = "virifySubsUserLog"

    override fun doInBackground(vararg params: String?): String {

        val connection = URL("https://divertenet.com.br/utils/controll/vrifyUserIsSubscriber.php?login=$login&senha=$senha")
            .openConnection() as HttpURLConnection
        var text: String = ""

        try {
            connection.connect()
            text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }

        } finally {

        }

        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        val lista:List<User> = handler(result)

        if(lista.isNotEmpty()){
            for (user: User in lista){
                //verify isPaid == true
                if(user.isPaid){
                    context.startActivity(Intent(context, MainActivity::class.java))
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