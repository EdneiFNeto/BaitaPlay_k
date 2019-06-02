package com.example.baitaplay_k.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.baitaplay_k.model.User

private val DB_VERSION = 1
private val DB_NAME = " db_baitaplay "
private val TABLE_NAME = " users "
private val ID = " id "
private val LOGIN = " login "
private val SENHA = " senha "

class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                ID+ " INTEGER PRIMARY KEY," +
                LOGIN + " TEXT, " +
                SENHA +" TEXT "+
                ")"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun save(user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(LOGIN, user.login)
        cv.put(SENHA, user.senha)
        var result = db.insert(TABLE_NAME, null, cv)

        if(result == -1.toLong()){
            Toast.makeText(context, "Failed save", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Success !", Toast.LENGTH_LONG).show()
        }
    }

    fun select():Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME ", null)
    }
}

