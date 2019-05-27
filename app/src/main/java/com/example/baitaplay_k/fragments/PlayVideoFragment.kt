package com.example.baitaplay_k.fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baitaplay_k.R
import kotlinx.android.synthetic.main.play_video_fragement.view.*

class PlayVideoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.play_video_fragement, container, false)
        view.video_view.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"))
        view.video_view.start()
        return view
    }

}
