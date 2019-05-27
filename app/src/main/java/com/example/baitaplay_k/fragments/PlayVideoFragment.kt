package com.example.baitaplay_k.fragments

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baitaplay_k.R

class PlayVideoFragment : Fragment() {

    val TAG: String = "PlayVideoFragmntLog"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.play_video_fragement, container, false)
        return view
    }

}
