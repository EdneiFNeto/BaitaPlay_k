package com.example.baitaplay_k.tasks

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.dao.UserDao
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.CheckConnectionUtil
import com.example.baitaplay_k.util.DialogUtil
import org.json.JSONArray
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class UpdateuserTask(val context: Context, val user: User) : AsyncTask<String, String, String>() {

    private val TAG: String = "LoginLog"

    override fun doInBackground(vararg params: String?): String? {

        if (CheckConnectionUtil.isNetworkAvailable(context)) {

            val connection =
                URL(
                    "https://divertenet.com.br/utils/controll/" +
                            "UpdateUserController.php?login=${user.login}&senha=${user.senha}"
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
        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        if (result != null) {

            val resp = handler(result)
            try {
                if (resp != null) {
                    if (resp == "200") {
                        Log.e(TAG, "Log 200")
                    }
                    if (resp == "401") {
                        Log.e(TAG, "Log 401")
                    }
                    if (resp == "500") {
                        Log.e(TAG, "Log 500")
                    }
                } else {
                    Log.e(TAG, "Null")
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error ${e.printStackTrace()}")
            }
        }else{
            DialogUtil.dialogNetworks(context)
        }
    }

    private fun handler(result: String?): String {

        val jsonArray = JSONArray(result)
        var x: Int = 0
        var resp = ""

        val jsonObject = jsonArray.getJSONObject(x)
        resp = jsonObject.getString("resp")

        return resp
    }

}