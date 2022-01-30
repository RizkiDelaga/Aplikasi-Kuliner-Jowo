package com.life4work.kulinerjowo

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class fullscreenYoutubeActivity : AppCompatActivity() {

    companion object{
        const val youtubeId = "ApXoWvfEYVU"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_youtube)

        //  Menyembunyikan Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //  Membuat Tampilan Layar Selalu LANDSCAPE
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        //  Variabel untuk menampung Intent yang dikirim melalui object INTENT_PARCELABLE
        val idVideo = intent.getStringExtra(youtubeId)

        //  Inisialisasi ID youtube_player_view
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        // Menambahkan object ID youtube_player_view ke lifecycle
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

            //  Menambahkan ID Video Youtube kedalam object video youtube
            override fun onReady(youTubePlayer: YouTubePlayer) {
                if (idVideo != null) {
                    youTubePlayer.cueVideo(idVideo,0f)
                }
                //  Tampilan video menjadi Fullscreen
                youTubePlayerView.enterFullScreen();
            }
        })

        //  Mengubah warna System Navigation Bottom menjadi Hitam
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black))
        }
    }
}