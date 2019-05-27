package com.example.baitaplay_k

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baitaplay_k.fragments.MainFragment
import com.example.baitaplay_k.fragments.RecycleViewCanais
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.framelayout_principal, MainFragment())
        transaction.commit()

        main_recycle_view.apply {
            adapter = RecycleViewCanais()
        }

    }
}
