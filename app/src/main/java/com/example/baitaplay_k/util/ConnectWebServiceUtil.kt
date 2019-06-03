package com.example.baitaplay_k.util

import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class ConnectWebServiceUtil {
    companion object {
        fun connectionWebService(url:String): String {
            val connection =
                URL(url).openConnection() as HttpURLConnection

            var text: String = ""

            try {
                connection.connect()
                text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return text
        }

    }
}