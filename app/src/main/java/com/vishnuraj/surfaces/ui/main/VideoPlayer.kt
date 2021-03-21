package com.vishnuraj.surfaces.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.vishnuraj.surfaces.R


class VideoPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val vView : VideoView = findViewById(R.id.video_view)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(vView)
        vView.setVideoPath("https://devstreaming-cdn.apple.com/videos/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8")
        vView.setMediaController(mediaController)
        vView.requestFocus()
        vView.start()

        val progressDialog = ProgressDialog.show(this, "Please wait...",
                "Loading your video...", true);
        vView.setOnPreparedListener {
            progressDialog.dismiss()
        }
    }
}


