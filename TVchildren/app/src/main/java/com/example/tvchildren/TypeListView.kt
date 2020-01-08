package com.example.tvchildren

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tvchildren.Class_GlobleVarable.Companion.IMDbUrl
import com.example.tvchildren.Class_GlobleVarable.Companion.Lovelist
import com.example.tvchildren.Class_GlobleVarable.Companion.LovelistData
import com.example.tvchildren.Class_GlobleVarable.Companion.Luid
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class TypeListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typelistview)

        var type = intent.getStringExtra("Type")
        var Type = "%"+ type +"%"
        var kind = intent.getStringExtra("kind")

        var too:String = "http://140.136.149.225:80/search_movie.php"

//        when(kind){
//            "Movie" -> too = ""
//            "Short" -> too = "http://140.136.149.225:80/search_short.php"
//            "TV" -> too = "http://140.136.149.225:80/search_tv.php"
//            else -> too = "http://140.136.149.225:80/search_movie.php"
//        }

//        Log.d("Type", Type)

        var listv = findViewById<ListView>(R.id.Type_ListView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1)
        listv.adapter = adapter

        //okhttp

        val client = OkHttpClient()
        val body = FormBody.Builder()
            .add("name","%")
            .add("genres", Type)
            .build()
        val request = Request.Builder()
            .url(too)
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("onResponse", "in here")

                    Log.i("kkkkk",response.toString())
                    Log.i("kkkkk",response.body().toString())

                    var responseData = response.body()?.string()?:""
//                            Log.i("seeRespond",response.body()!!.string())
                    if (responseData  != ""){
                        try {
                            var jsonarray = JSONArray(responseData)
                            for(i in 0..19){
                                if(!jsonarray.isNull(i)){
                                    val json = jsonarray.getJSONObject(i)
                                    adapter.addAll(json.getString("primaryTitle" )+ "\n" + json.getString("originalTitle") + "\t" + json.getString("startYear"))
                                }
                            }
                            listv.setOnItemClickListener{parent, view, position, id ->
                                var title = jsonarray.getJSONObject(position).get("primaryTitle").toString()
                                var t = jsonarray.getJSONObject(position).get("tconst").toString()
                                openDialog(t, title)
                                Log.d("tconst", t)
                            }

                            var i = 0
                            listv.setOnItemLongClickListener { parent, view, position, id ->
                                Log.d("Tag", "setOnItemLongClickListener")
                                Log.d("Luid", Luid.toString())

                                var a:String = "https://www.imdb.com/title/"
                                var c:String = "/?ref_=nv_sr_srsg_0"
                                var tconst = jsonarray.getJSONObject(position).get("tconst").toString()
                                var url = a + tconst +c
                                var primary = jsonarray.getJSONObject(position).get("primaryTitle").toString()
                                var original = jsonarray.getJSONObject(position).get("originalTitle").toString()
                                var startYear = jsonarray.getJSONObject(position).get("startYear").toString()


                                val body = FormBody.Builder()
                                    .add("id", Luid.toString())
                                    .add("tconst", tconst)
                                    .add("primary", primary)
                                    .add("original", original)
                                    .build()

                                val body2 = FormBody.Builder()
                                    .add("id", Luid.toString())
                                    .add("tconst", tconst)
                                    .build()

                                if(Luid == 0){
                                    Toast.makeText(this@TypeListView, "Please Login First", Toast.LENGTH_SHORT).show()
                                } else{
                                    if(!Lovelist.contains(tconst)){
                                        insertlove(body)
                                        Lovelist.add(tconst)
                                        LovelistData.add(Class_GlobleVarable.Companion.LoveData(primary,original,startYear,url))
                                        Log.d("In-primary", primary)
                                        Log.d("In-original", original)
                                        Log.d("In-startYear", startYear)
                                        Log.d("In-url", url)
                                        Log.d("In-LIST", LovelistData[i].primary)
                                        i = i + 1
                                        Toast.makeText(this@TypeListView, "Insert in to Favorite", Toast.LENGTH_SHORT).show()
                                    } else{
                                        deletelove(body2)
                                        Lovelist.remove(tconst)
                                        LovelistData.remove(Class_GlobleVarable.Companion.LoveData(primary,original,startYear,url))
                                        Toast.makeText(this@TypeListView, "You have deleted the Favorite", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                true
                            }

                        }catch (e: JSONException){
                            Log.d("Jsonerror ",e.message)
                        }
                    }


                }

            }
        })
    }

    fun openDialog(ttconst:String, title:String){
        var build =  AlertDialog.Builder(this)
        build.setTitle(title)
        build.setMessage("Go to IMDb")
        build.setPositiveButton("See more on IMDb"){dialog, which ->
            //https://www.imdb.com/title/tt1475582/?ref_=nv_sr_srsg_0
            var a:String = "https://www.imdb.com/title/"
            var c:String = "/?ref_=nv_sr_srsg_0"
            var add = a + ttconst + c
            IMDbUrl = add
            var intent = Intent(this, SetWebView::class.java)
            startActivity(intent)
        }
        val Dialog = build.create()
        Dialog.show()
    }

    fun insertlove(body:FormBody){
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://140.136.149.225:80/insertlove.php")
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("OnResponse_insertlove", "In here")
                }
            }
        })
    }

    fun deletelove(body:FormBody){
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://140.136.149.225:80/deletelove.php")
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("delete_live", "In here")
                }
            }
        })
    }

}
