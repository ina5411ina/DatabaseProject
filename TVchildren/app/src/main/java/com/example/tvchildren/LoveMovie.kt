package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvchildren.Class_GlobleVarable.Companion.LovelistData
import com.example.tvchildren.Class_GlobleVarable.Companion.Luid
import com.example.tvchildren.datapic.new
import kotlinx.android.synthetic.main.activity_love_movie.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class LoveMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_movie)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1)
        love_movie.adapter = adapter

        val client = OkHttpClient()
        val body = FormBody.Builder()
            .add("id",Luid.toString())
            .build()
        val request = Request.Builder()
            .url("http://140.136.149.225:80/favorite.php")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("Favorite", "In here")
                    var responseData = response.body()?.string()?:""
//                            Log.i("seeRespond",response.body()!!.string())
                    if (responseData  != ""){
                        try {
                            var jsonarray = JSONArray(responseData)
                            for(i in 0..jsonarray.length()){
                                if(!jsonarray.isNull(i)){
                                    val json = jsonarray.getJSONObject(i)
                                    adapter.addAll(json.getString("primaryTitle" )+ "\n" + json.getString("originalTitle"))
                                }
                            }


                        }catch (e: JSONException){
                            Log.d("Jsonerror ",e.message)
                        }
                    }

                }
            }
        })
//        for(i in LovelistData){
//            adapter.addAll(i.primary + "\n" + i.original + "\t" + i.startYear)
//        }

        love_movie.setOnItemClickListener { parent, view, position, id ->
            var title = LovelistData[position].primary
            var url = LovelistData[position].url
            openDialog(title, url)
        }



//        love_recycle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
//        love_recycle.adapter = LoveAdapter(this, LovelistData)
//        love_recycle.adapter = MainViewAdapter(this@LoveMovie, new)

    }
    fun openDialog(title:String, url:String){
        var build =  AlertDialog.Builder(this)
        build.setTitle(title)
        build.setMessage("Go to IMDb")
        build.setPositiveButton("See more on IMDb"){dialog, which ->
            //https://www.imdb.com/title/tt1475582/?ref_=nv_sr_srsg_0
            Class_GlobleVarable.IMDbUrl = url
            var intent = Intent(this, SetWebView::class.java)
            startActivity(intent)
        }
        val Dialog = build.create()
        Dialog.show()
    }
}
