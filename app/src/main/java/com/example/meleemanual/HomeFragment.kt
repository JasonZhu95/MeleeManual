package com.example.meleemanual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

class HomeFragment : Fragment() {

    private lateinit var recentSetOne : YouTubePlayerView
    private lateinit var controllerListener : YouTubePlayerListener
    private lateinit var defaultPlayerUIController : DefaultPlayerUiController
    private lateinit var options : IFramePlayerOptions

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        recentSetOne = view.findViewById(R.id.recentSetOne)
        lifecycle.addObserver(recentSetOne)

        recentSetOne.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "4CPrPuvML8A"
                youTubePlayer.cueVideo(videoId, 0f)
                
            }
        })

        controllerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                defaultPlayerUIController = DefaultPlayerUiController(recentSetOne, youTubePlayer)
                recentSetOne.setCustomPlayerUi(defaultPlayerUIController.rootView)
            }
        }
        options = IFramePlayerOptions.Builder().controls(0).build()
        recentSetOne.initialize(controllerListener, options)

        return view
    }

}