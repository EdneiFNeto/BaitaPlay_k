package com.example.baitaplay_k.tasks

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.example.baitaplay_k.MainActivity
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.dao.UserDao
import com.example.baitaplay_k.model.User
import com.example.baitaplay_k.util.DialogUtil
import org.json.JSONArray
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class loginUserTasks(val context: Context, val login: String, val senha: String) : AsyncTask<String, String, String>() {

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
                    //save users data base
                    val dao  = UserDao()
                    val user = User(login, senha, false)
                    val db = DataBaseHandler(context)

                    Log.e(TAG, "Users: ${user.toString()}" )
                    db.save(user)
                    val intent = Intent(context, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                }

                if (resp == "401") {
                    DialogUtil.Companion.userNotauthorized(context)
                }
                if (resp == "500") {
                    DialogUtil.Companion.errorServer(context)
                } else {
                    DialogUtil.Companion.userNotauthorized(context)
                }
            } else {
                Log.e(TAG, "Null")
            }

        } catch (e: Exception) {

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