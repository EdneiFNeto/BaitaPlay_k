package com.example.baitaplay_k.tasks

import android.os.Build

class CheckVersionAndroidTasks {

    companion object {

        //verify version higher whit KitKat
        fun veryfyVersionHigherKitkat(): Boolean {
            return Build.VERSION.SDK_INT > 19
        }
    }
}