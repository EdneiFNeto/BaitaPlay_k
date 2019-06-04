package com.example.baitaplay_k.tests

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.baitaplay_k.R
import com.example.baitaplay_k.util.CheckConnectionUtil
import java.lang.Exception

class TestActivity : AppCompatActivity() {

    val TAG = "TestLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        try {

            if (CheckConnectionUtil.Companion.isNetworkAvailable(this)) {
                Log.e(TAG, "Connected ")
            } else {
                Log.e(TAG, "Not connected ")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "Exception ${e.message}")
        }
    }


}
