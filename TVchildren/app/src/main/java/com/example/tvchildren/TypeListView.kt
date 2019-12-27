package com.example.tvchildren

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
            .url("http://140.136.149.225:80/search_movie.php")
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("onResponse", "in here")

                    var responseData = response.body()!!.string()
//                            Log.i("seeRespond",response.body()!!.string())

                    try {
                        var jsonarray = JSONArray(responseData)
                        for(i in 0..19){
                            if(!jsonarray.isNull(i)){
                                val json = jsonarray.getJSONObject(i)
                                adapter.addAll(json.getString("primaryTitle")+ "\t" +json.getString("startYear"))
                            }
                        }
                        listv.setOnItemClickListener{parent, view, position, id ->
                            var title = jsonarray.getJSONObject(position).get("primaryTitle").toString()
                            var t = jsonarray.getJSONObject(position).get("tconst").toString()
                            openDialog(t, title)
                            Log.d("tconst", t)
                        }

                    }catch (e: JSONException){
                        Log.d("Jsonerror ",e.message)
                    }
                }

            }
        })
    }

    fun openDialog(ttconst:String, title:String){
        var build =  AlertDialog.Builder(this)
        build.setTitle(title)
        build.setMessage("Go to IMDb")
        build.setPositiveButton("Go"){dialog, which ->
            //https://www.imdb.com/title/tt1475582/?ref_=nv_sr_srsg_0
            val a:String = "https://www.imdb.com/title/"
            val c:String = "/?ref_=nv_sr_srsg_0"
            var add = a + ttconst + c
            val uri: Uri = Uri.parse(add)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val Dialog = build.create()
        Dialog.show()
    }
}
