package com.example.baitaplay_k.tasks

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.CheckConnectionUtil
import com.example.baitaplay_k.util.DialogUtil
import org.json.JSONArray
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class AuthentuicationUserTasks(val context: Context, val user: User) : AsyncTask<String, String, String>() {

    private val TAG: String? = "SubiscrobeLog"

    override fun doInBackground(vararg params: String?): String? {

        if (CheckConnectionUtil.isNetworkAvailable(context)) {

            val connection = URL(
                "https://divertenet.com.br/utils/controll/" +
                        "vrifyUserIsSubscriber.php?login=${user.login}&senha=${user.senha}"
            )
                .openConnection() as HttpURLConnection

            var text: String = ""

            try {
                connection.connect()
                text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }

            } catch (e: Exception) {
                Log.e(TAG, "Excepion ${e.message}")
            }

            return text
        }

        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        try {
            if (result != null) {
                val resp: String = handler(result)
                if (resp != null) {
                    if (resp != "200") {
                        //verify user is subscribe
                        DialogUtil.Companion.dialogNotSgnature(context)
                    }
                }
            } else {
                DialogUtil.dialogNetworks(context)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Execption ${e.message}")
        }
    }

    private fun handler(result: String?): String {
        val jsonArray = JSONArray(result)
        val jsonObject = jsonArray.getJSONObject(0)
        Log.e(TAG, "Objetos ${jsonObject.toString()}")
        return jsonObject.getString("resp")
    }
}