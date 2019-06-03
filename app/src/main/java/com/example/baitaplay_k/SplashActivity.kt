package com.example.baitaplay_k

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.baitaplay_k.dao.DataBaseHandler
import com.example.baitaplay_k.tasks.VerifyExistisUserTasks

class SplashActivity : AppCompatActivity() {

    private val TAG: String = "SplashLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


    }

    override fun onResume() {
        super.onResume()

        var login: String? = null
        var senha: String? = null
        val db = DataBaseHandler(this)
        val cursor: Cursor = db.select()

        if (cursor != null) {
            while (cursor.moveToNext()) {
                login = cursor.getString(cursor.getColumnIndex("login"))
                senha = cursor.getString(cursor.getColumnIndex("senha"))
            }

            Handler().postDelayed(Runnable {
                VerifyExistisUserTasks(this, login.toString(), senha.toString()).execute()
            }, 3000)
        }

    }
}
