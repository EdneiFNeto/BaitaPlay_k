package com.example.baitaplay_k.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baitaplay_k.R
import com.example.baitaplay_k.adapter.RecycleViewCanais
import com.example.baitaplay_k.util.ListaDeCanalUtil
import kotlinx.android.synthetic.main.main_fragement.view.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.main_fragement, container, false)



        return view
    }

}
