package com.example.baitaplay_k.tasks

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.LoginActivity
import com.example.baitaplay_k.MainActivity
import org.json.JSONArray
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class VerifyExistisUserTasks(
    val context: Context,
    val login: String,
    val senha: String
) : AsyncTask<String, String, String>() {

    private val TAG: String = "LoginLog"

    override fun doInBackground(vararg params: String?): String {

        val connection =
            URL(
                "https://divertenet.com.br/utils/controll/" +
                        "LoginAppBaitaplayController.php?login=$login&senha=$senha"
            )
                .openConnection() as HttpURLConnection

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

        val resp = handler(result)
        try {
            if (resp != null) {
                if (resp == "200") {
                    Log.e(TAG, "Log 200")
                    irParaMainActivity()
                }
                if (resp == "401") {
                    irParaActivityLogin()
                    Log.e(TAG, "Log 401")
                }
                if (resp == "500") {
                    Log.e(TAG, "Log 500")
                    irParaActivityLogin()
                }
            } else {
                Log.e(TAG, "Null")
                irParaActivityLogin()
            }

        } catch (e: Exception) {

        }
    }

    private fun irParaMainActivity() {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

    private fun handler(result: String?): String {

        val jsonArray = JSONArray(result)
        var x: Int = 0
        var resp = ""

        val jsonObject = jsonArray.getJSONObject(x)
        resp = jsonObject.getString("resp")
        return resp
    }

    private fun irParaActivityLogin() {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

}