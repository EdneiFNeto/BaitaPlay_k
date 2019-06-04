package com.example.baitaplay_k.tasks

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.DialogUtil
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class VerifyUserSubscriTasks(context: Context, login: String, senha: String) : AsyncTask<String, String, String>() {

    private val login: String = login
    private val senha: String = senha
    private val context: Context = context
    private val TAG: String = "virifySubsUserLog"

    override fun doInBackground(vararg params: String?): String {

        val connection =
            URL("https://divertenet.com.br/utils/controll/vrifyUserIsSubscriber.php?login=$login&senha=$senha")
                .openConnection() as HttpURLConnection
        var text: String = ""

        try {
            connection.connect()
            text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }

        } finally {

        }

        Log.e(TAG, "Login $login\nSenha: $senha")
        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        val resp: String = handler(result)

        if (resp != null) {
            //user is subscriber
            if (resp == "200") {
                context.startActivity(Intent(context, MainActivity::class.java))
            }
        }
    }

    private fun handler(result: String?): String {
        val jsonArray = JSONArray(result)
        val jsonObject = jsonArray.getJSONObject(0)
        Log.e(TAG, "Objetos ${jsonObject.toString()}")
        return jsonObject.getString("resp")
    }
}