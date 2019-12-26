package com.example.tvchildren

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.Transition.ViewAdapter
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.recycleview.*


class FragmentMain : Fragment() {
     val T = "FragmentMain"

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
        val inflate =  inflater!!.inflate(R.layout.fragment_main, container, false)


        var imglist:MutableList<Imgdata> = mutableListOf()
        for(i in datapic.groups){
//            imglist.clear()
            imglist.add(i)
        }
//        inflate.main_recycleview.layoutManager = LinearLayoutManager(inflate.context)
        inflate.main_recycleview.adapter = MainViewAdapter(inflate.context, imglist)

        var img2:MutableList<Imgdata> = mutableListOf()
        for(j in datapic.new){
//            imglist.clear()
            img2.add(j)
        }
//        inflate.main_recycleview.layoutManager = LinearLayoutManager(inflate.context)
        inflate.new_view.adapter = MainViewAdapter(inflate.context, img2)

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
