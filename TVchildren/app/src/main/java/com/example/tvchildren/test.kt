package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_serach_page.*
import kotlinx.android.synthetic.main.inner_movie.*
import kotlinx.android.synthetic.main.recycleview.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        val toolbar: Toolbar = findViewById(com.example.tvchildren.R.id.toolbar)
        setSupportActionBar(findViewById(com.example.tvchildren.R.id.toolbar))

        btnfind_movie.setOnClickListener{
            Log.d("aaa","btn ok")
            var list = mutableListOf<Adapter.Model>()
            var str =search.query.toString() + "%"

            val body = FormBody.Builder().add("name", str).build()
            testTT.setText(str)

            var client = OkHttpClient()
            var request = Request.Builder()
                .url("http://140.136.149.225:80/search movie.php")
                .post(body)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread(){
                        Log.d("@@@",e.message)
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    var str = response.body()!!.string()
                    runOnUiThread(){
                        try{
                            val jsonarray = JSONArray(str)
                            var json:JSONObject
                            var out:String
                            var year:String
                            var s:String
                            for(i in 0..19){
                                if(!jsonarray.isNull(i)){
                                    s = testTT.text.toString()
                                    json = jsonarray.getJSONObject(i)
                                    out = json.get("primaryTitle").toString()
                                    year = json.get("startYear").toString()
                                    list.add(0, Adapter.Model(
                                        "http://res.pokemon.name/common/pokemon/pgl/143.00.png",
                                        "test",
                                        "test"
                                    ))
                                    testTT.setText(s+out+year+"   "+ list + "\n")
                                }
                            }
                        }
                        catch(e:JSONException){
                            Log.d("Json error:",e.message)
                        }
                    }
                }
            })
            setAdapter()
            list.clear()
        }

    }
    fun setAdapter(){
        Log.d("Adapter", "in here")
        recycleview.adapter = Adapter(this, list)
        recycleview.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(com.example.tvchildren.R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            com.example.tvchildren.R.id.movie -> {
                Toast.makeText(applicationContext, "click on movie", Toast.LENGTH_LONG).show()
                true
            }
            com.example.tvchildren.R.id.sho ->{
                Toast.makeText(applicationContext, "click on short", Toast.LENGTH_LONG).show()
                return true
            }
            com.example.tvchildren.R.id.tv ->{
                Toast.makeText(applicationContext, "click on tv", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
