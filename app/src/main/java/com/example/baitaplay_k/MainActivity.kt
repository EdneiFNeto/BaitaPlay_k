package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.framelayout_principal, MainFragment())
        transaction.commit()
    }
}
