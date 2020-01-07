package com.example.tvchildren

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.register.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class RegisterActivity : AppCompatActivity() {

    internal var RegisterURL = "http://140.136.149.225:80/註冊.php"
    private var preferenceHelper: PreferenceHelper? = null
    private val RegTask = 1
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var etusername = findViewById<EditText>(R.id.etusername)
        var etpassword = findViewById<EditText>(R.id.etpassword)
        var birthy = findViewById<EditText>(R.id.etbitrh)
        var birthm =  findViewById<EditText>(R.id.etbitrhmonth)
        var birthd = findViewById<EditText>(R.id.etbitrhday)

        preferenceHelper = PreferenceHelper(this)

//        if (preferenceHelper!!.getIsLogin()) {
//            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//            this.finish()
//        }

        var btnregister = findViewById<View>(R.id.btn)
        var tvlogin = findViewById<TextView>(R.id.tvlogin)

        tvlogin.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnregister!!.setOnClickListener(){
            try {
//                register()
                val client = OkHttpClient()
                val body = FormBody.Builder()
                    .add("name", etusername.text.toString())
                    .add("birthyear", birthy.text.toString())
                    .add("birthmon", birthm.text.toString())
                    .add("birthday", birthd.text.toString())
                    .add("password", etpassword.text.toString())
                    .build()

                val request = Request.Builder()
                    .url(RegisterURL)
                    .post(body)
                    .build()

                client.newCall(request).enqueue(object: Callback{
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("onFailure", e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        runOnUiThread {
                            Log.d("onResponse", "in here")
                            var responseData = response.body()!!.string()
                            try{
                                var json = JSONArray(responseData)
                                var uid= json.getJSONObject(0).get("uid")
                                Log.d("uid", uid.toString())
                                if(uid != 0){
                                    var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                    startActivity(intent)
                                }

                            }catch (e:JSONException){
                                Log.d("Jsonerror", e.message)
                            }
                        }
                    }
                })
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
//



    }

    private fun register() {
        val client = OkHttpClient()
        val body = FormBody.Builder()
            .add("birthyear", "1999")
            .add("birthmon", "3")
            .add("birthday", "9")
            .add("password", etpassword.text.toString())
            .build()

        val request = Request.Builder()
            .url(RegisterURL)
            .post(body)
            .build()

//        showSimpleProgressDialog(this@RegisterActivity, null, "Loading...", false)

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    Log.d("onResponse", "in here")
                    var responseData = response.body()!!.string()
                    try{
                        var json = JSONObject(responseData)
                        var uid= json.get("id")
                        Log.d("uid", uid.toString())
                    }catch (e:JSONException){
                        Log.d("Jsonerror", e.message)
                    }
                }
            }
        })

    }


    private fun onTaskCompleted(response: Any, task: Int) {
        Log.d("responsejson", response.toString())
//        removeSimpleProgressDialog()
        when (task) {
            RegTask -> if (response != 0) {
                Toast.makeText(this@RegisterActivity, "Registered Successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                this.finish()
            }
        }
    }


}