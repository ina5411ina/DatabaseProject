package com.example.tvchildren

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class getTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.getdatatetest0104)

        var tconst = intent.getStringExtra("tconst")
//        Log.d("Type", Type)
        var text = findViewById<TextView>(R.id.textView_testdata)


        //okhttp

        val client = OkHttpClient()
        val body = FormBody.Builder()
            .add("tconst","tt0015724")
            .build()
        val request = Request.Builder()
            .url("http://140.136.149.225/search_actor.php")
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", "1111111")
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread(){
                    Log.d("onResponse", "in here")

                    var responseData = response.body()!!.string()
                    Log.i("seeRespond",response.body()!!.string())
                    Log.i("seeRespond",response.body()!!.string())

                    try {
                        var jsonarray = JSONArray(responseData)
                        for(i in 0..1){
                            if(!jsonarray.isNull(i)){
                                val json = jsonarray.getJSONObject(i)
                                var title = json.get("primaryName").toString()
                                var tt = json.get("category").toString()
                                var t = text.text.toString()
                                Log.d("actor", title)
                                text.setText(t + '\n' + title)
                            }
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
