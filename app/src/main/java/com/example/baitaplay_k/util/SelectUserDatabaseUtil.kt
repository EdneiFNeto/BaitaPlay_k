package com.example.baitaplay_k.util

import android.content.Context
import android.database.Cursor
import com.example.baitaplay_k.dao.DataBaseHandler

class SelectUserDatabaseUtil {

    companion object {
        fun selectUser(context: Context): String? {
            val db = DataBaseHandler(context)
            var login: String? = null
            val cursor: Cursor = db.select()

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    login = cursor.getString(cursor.getColumnIndex("login"))
                }
                if (login != null) {
                    if (!login.isEmpty())
                        return login.toString()
                }
            }

            return null
        }
    }
}