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
import com.example.tvchildren.Class_GlobleVarable.Companion.firstState
import com.example.tvchildren.Class_GlobleVarable.Companion.imglist
import com.example.tvchildren.Kind_of_Adapter.Adapter_pic
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.recycleview.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import kotlin.concurrent.timer


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



//        inflate.main_recycleview.layoutManager = LinearLayoutManager(inflate.context)


        //okhttp
        if(firstState == 0){
            firstState = 1
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("http://140.136.149.225:80/yearmovie.php")
                .build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("onFailure", e.message)
                }

                override fun onResponse(call: Call, response: Response) {
                    activity!!.runOnUiThread(){
                        Log.d("onResponse", "in here")
                        var responseData = response.body()!!.string()
//                            Log.i("seeRespond",response.body()!!.string())
                        try {
                            var jsonarray = JSONArray(responseData)
                            for(i in 0..jsonarray.length()){
                                val json = jsonarray.getJSONObject(i)
                                if(jsonarray.getJSONObject(i) != null && json.get("im") != "null" ) {
                                    imglist.add(json.getString("im"))
                                }
                            }

                        }catch (e: JSONException){
                            Log.d("Jsonerror ",e.message)
                        }
                    }

                }
            })
        }

        //okhttp end

//        inflate.main_recycleview.adapter = MainViewAdapter(inflate.context, imglist)
        inflate.main_recycleview.adapter = Adapter_pic(inflate.context, imglist)

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
