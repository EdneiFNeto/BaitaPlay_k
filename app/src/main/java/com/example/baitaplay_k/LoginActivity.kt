package com.example.baitaplay_k

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(my_toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayShowTitleEnabled(false)



    }

}
