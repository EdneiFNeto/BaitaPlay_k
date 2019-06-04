package com.example.baitaplay_k.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.content.ContextCompat.getSystemService

class CheckConnectionUtil {
    companion object {
        fun isNetworkAvailable(context:Context): Boolean {

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            return if (connectivityManager is ConnectivityManager) {
                val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            } else false
        }
    }
}