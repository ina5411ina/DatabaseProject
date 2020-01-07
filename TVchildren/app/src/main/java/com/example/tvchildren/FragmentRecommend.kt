package com.example.tvchildren

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_recommend.*


class FragmentRecommend : Fragment() {
     val T = "FragmentRecommend"

    override fun onAttach(context: Context) {
        Log.d(T, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(T, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(T, "onCreateView")
        var inflate = inflater!!.inflate(R.layout.fragment_recommend, container, false)
        var layout = inflate.findViewById<View>(R.id.fragment_recommend)
        var video = inflate.findViewById<VideoView>(R.id.video)
        var video2 = inflate.findViewById<WebView>(R.id.video2)

        var mediaController: MediaController? = null

        video.setVideoPath("https://imdb-video.media-imdb.com/vi2143993625/1434659607842-pgv4ql-1574275019638.mp4?Expires=1578482633&Signature=oSrMI3MhoXnJbp7K5RW8UATEqMwRE~vBLwQfVlAY7K5ke6xxXKqepBUjDKXNnhON5AyQfMTVmHpriDEYQL6AWsq8olOqMI-VS2Tw1YwS4CS0OlReAP9Yxtm85rmrWuePGL15e47arxI0kF~q7-1J1bhOF3DjJPId18KMLWYoBZXgehhVjg~~mDm4aDBxB5X1okAVtad~ghUHcK7Q6nTOH4VjtG8QGYN15k1cWNKDeSmnMs9PWtj~v3I4jAhiro6SW4ySXP~xAozLHhaNm0DOmT5cIvLwYOmLzZ-2qsRMBh3DEG9fTiN9vl~fVGN4NLymhKrasIx~nwVIZtaqfnZQew__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA")
        mediaController = MediaController(layout.context)
        mediaController?.setAnchorView(video)
        video.setMediaController(mediaController)
        video.start()

        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(T, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(T, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(T, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(T, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(T, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(T, "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d(T, "onDestroyView")
        super.onDestroyView()
    }
    override fun onDetach() {
        Log.d(T, "onDetach")
        super.onDetach()
    }


}
