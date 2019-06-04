package com.example.baitaplay_k.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.baitaplay_k.model.User

private val DB_VERSION = 1
private val DB_NAME = " db_baitaplay "
private val TABLE_NAME = " users "
private val ID = " id "
private val LOGIN = " login "
private val SENHA = " senha "

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    private val TAG= "DatabaseLog"

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY," +
                LOGIN + " TEXT, " +
                SENHA + " TEXT " +
                ")"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun save(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(LOGIN, user.login)
        cv.put(SENHA, user.senha)

        try {
            var result = db.insert(TABLE_NAME, null, cv)

            if (result == -1.toLong()) {
                Toast.makeText(context, "Failed save", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Save user whit success !", Toast.LENGTH_LONG).show()
            }
        }catch (ex:SQLiteException){
            Log.e(TAG, "Error: ${ex.printStackTrace()}")
        }finally {
            db.close()
        }
    }

    fun select(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME ", null)
    }

    fun update(user: User, login: String) {
        val db = this.writableDatabase
        var values = ContentValues()
        values.put(" login ", user.login)
        values.put(" senha ", user.senha)

        try {
            val res = db.update(TABLE_NAME, values, " login = $login ", null)
            if (res >= 1) {
                Toast.makeText(context, "Updater success !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error Updater !", Toast.LENGTH_SHORT).show()
            }
        } catch (ex: SQLiteException) {
            Toast.makeText(context, "Error Updater !${ex.message}", Toast.LENGTH_SHORT).show()
            ex.printStackTrace()
        } finally {
            db.close()
        }
    }

    fun delete(): Boolean {
        val db = this.writableDatabase
        try {
            val res = db.delete(TABLE_NAME, null, null)
            if (res >= 1) {
                return  true
            }
        } catch (ex: SQLiteException) {
            Log.e(TAG, "Error: ${ex.printStackTrace()}")
        } finally {
            db.close()
        }

        return false

    }
}

