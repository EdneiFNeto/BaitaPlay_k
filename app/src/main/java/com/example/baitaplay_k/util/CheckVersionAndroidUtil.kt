package com.example.baitaplay_k.util

import android.os.Build

class CheckVersionAndroidUtil {

    companion object {

        //verify version higher whit KitKat
        fun veryfyVersionHigherKitkat(): Boolean {
            return Build.VERSION.SDK_INT > 19
        }
    }
}