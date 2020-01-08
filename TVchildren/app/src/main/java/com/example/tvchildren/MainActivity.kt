package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.Toast
import com.example.tvchildren.Class_GlobleVarable.Companion.RecommendUrl
import com.example.tvchildren.Class_GlobleVarable.Companion.hobbyState
import com.example.tvchildren.Class_GlobleVarable.Companion.login_tag
import com.example.tvchildren.test.Adapter
import kotlinx.android.synthetic.main.activity_edituserpage.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.util.*


val list = mutableListOf<Adapter.Model>()

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main_btn = findViewById<Button>(R.id.btn_main)
        val search_btn = findViewById<Button>(R.id.btn_search)
        val recommend_btn = findViewById<Button>(R.id.btn_recommend)
        val like_btn = findViewById<Button>(R.id.btn_like)

        ShowFragmentMain()
        main_btn.setOnClickListener(){
            ShowFragmentMain()
        }
        search_btn.setOnClickListener(){
            startActivity(Intent(this, testpage::class.java))
            Log.d("aaa","btn ok")
        }
        recommend_btn.setOnClickListener(){
            if(login_tag == 0){
                ShowFragmentRecommend()
            } else{
                if(hobbyState == 1){
                    val client = OkHttpClient()

                    val body = FormBody.Builder()
                        .add("id", Class_GlobleVarable.Luid.toString())
                        .build()

                    val request = Request.Builder()
                        .url("http://140.136.149.225:80/recommend.php")
                        .post(body)
                        .build()

                        client.newCall(request).enqueue(object : Callback {
                            override fun onFailure(call: Call, e: IOException) {
                                Log.d("onFailure", e.message)
                            }

                            override fun onResponse(call: Call, response: Response) {
                                Thread(){
                                    var responseData = response.body()!!.string()
//                            Log.i("seeRespond",response.body()!!.string())
                                    try {
                                        var jsonarray = JSONArray(responseData)

                                        var len = jsonarray.length()

                                        val json = jsonarray.getJSONObject(0)
                                        var tconst = json.getString("tconst" )
                                        var a:String = "https://www.imdb.com/title/"
                                        var c:String = "/?ref_=nv_sr_srsg_0"
                                        var url = a + tconst + c
                                        RecommendUrl = url
                                        Log.d("Tconst", tconst)


                                    }catch (e: JSONException){
                                        Log.d("Jsonerror ",e.message)
                                    }

                                }.start()
                            }
                        })




                    ShowFragmentRecommend2()
                }
                else{
                    ShowFragmentRecommend()
                }
            }
        }
        like_btn.setOnClickListener(){
            if(login_tag == 0){
                ShowFragmentLike()
            }
            else{
                ShowFragmentLike_Sec()
            }
        }

    }

    fun ShowFragmentMain(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentMain()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun ShowFragmentRecommend(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentRecommend()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun ShowFragmentRecommend2(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentRecommend2()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun ShowFragmentLike(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentLike()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun ShowFragmentLike_Sec(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentLike_Sec()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
