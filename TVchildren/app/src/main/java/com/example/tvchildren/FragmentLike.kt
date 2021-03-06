package com.example.tvchildren

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tvchildren.Class_GlobleVarable.Companion.favoritelist
import com.example.tvchildren.Class_GlobleVarable.Companion.userName
import com.example.tvchildren.crawler.Crawler
import kotlinx.android.synthetic.main.fragment_like.*
import java.util.jar.Attributes


class FragmentLike() : Fragment() {
    val T = "FragmentLike"

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
        val inflate = inflater.inflate(R.layout.fragment_like, container, false)


        val layout = inflate.findViewById<View>(R.id.fragment_like)
        val testLogin = inflate.findViewById<Button>(R.id.testLogin)
//        val ttdata = inflate.findViewById<TextView>(R.id.ttdata)
//        val testCrawler = inflate.findViewById<Button>(R.id.testCrawler)




        testLogin.setOnClickListener(){
            var intent = Intent(layout.context, RegisterActivity::class.java)
            startActivity(intent)
        }
//
//        ttdata.setOnClickListener(){
//            var intent = Intent(layout.context, getTest::class.java)
//            startActivity(intent)
//        }

//        testCrawler.setOnClickListener(){
//            var url = "https://www.imdb.com/title/tt4520988/?ref_=nv_sr_srsg_0"
//            Crawler(url)
//        }
        return inflate
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
