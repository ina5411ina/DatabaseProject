package com.example.tvchildren

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tvchildren.Class_GlobleVarable.Companion.Luid
import com.example.tvchildren.Class_GlobleVarable.Companion.login_tag
import com.example.tvchildren.Class_GlobleVarable.Companion.userName
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    internal var LoginURL = "http://140.136.149.225:80/login.php"
    private val LoginTask = 1
    private var preferenceHelper: PreferenceHelper? = null
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        preferenceHelper = PreferenceHelper(this)

        var etusername = findViewById<EditText>(R.id.etusername)
        var etpassword = findViewById<EditText>(R.id.etpassword)
        var btnlogin = findViewById<Button>(R.id.btnlogin)
        var tvreg = findViewById<TextView>(R.id.tvreg)

        tvreg.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) 
        }
        btnlogin.setOnClickListener(){
            try {
//                login()
                if(etusername.text.toString() != "" && etpassword.text.toString() != ""){
                    val client = OkHttpClient()
                    val body = FormBody.Builder()
                        .add("name",etusername.text.toString() )
                        .add("password", etpassword.text.toString())
                        .build()


                    val request = Request.Builder()
                        .url(LoginURL)
                        .post(body)
                        .build()

                    client.newCall(request).enqueue(object: Callback {
                        override fun onFailure(call: Call, e: IOException) {
                            Log.d("onFailure", e.message)
                        }

                        override fun onResponse(call: Call, response: Response) {
                            runOnUiThread {
                                Log.d("onResponse", "in here")
                                var responseData = response.body()!!.string()
                                Log.d("onResponseData", responseData)
                                try{
                                    var json = JSONArray(responseData)
                                    var uid= json.getJSONObject(0).get("uid")
                                    var islogined = json.getJSONObject(0).get("login")

                                    if(uid != 0){
                                        Log.d("uid","doen")
                                    }
                                    Log.d("login", islogined.toString())
                                    if(islogined.toString() == "true"){
                                        Luid = uid
                                        userName = etusername.text.toString()
                                        login_tag = 1
                                        var intent = Intent(this@LoginActivity, MainActivity::class.java)
                                        startActivity(intent)
                                    }else if(islogined.toString() == "false"){
                                        Log.d("login", islogined.toString())
                                    }
                                }catch (e:JSONException){
                                    Log.d("Jsonerror", e.message)
                                }
                            }
                        }
                    })
                }
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }

    private fun login() {

        showSimpleProgressDialog(this@LoginActivity, null, "Loading...", false)
        val client = OkHttpClient()
        val body = FormBody.Builder()
//            .add("password",etusername.text.toString() )
//            .add("password", etpassword.text.toString())
            .build()

        val request = Request.Builder()
            .url(LoginURL)
            .post(body)
            .build()

        showSimpleProgressDialog(this, null, "Loading...", false)

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("onFailure", e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    Log.d("onResponse", "in here")
                    var responseData = response.body()!!.string()
                    try{
                        var json = JSONArray(responseData)
                        var uid= json.getJSONObject(0).getString("uid")
                        var islogined = json.getJSONObject(0).getString("login")
//                        removeSimpleProgressDialog()
                        onTaskCompleted(uid,LoginTask)
                    }catch (e:JSONException){
                        Log.d("Jsonerror", e.message)
                    }
                }
            }
        })
    }

    private fun onTaskCompleted(response: String, task: Int) {
        Log.d("responsejson", response)
        removeSimpleProgressDialog()  //will remove progress dialog
        when (task) {
            LoginTask -> if (response == "true") {
                Toast.makeText(this@LoginActivity, "Login Successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                this.finish()
            } else {
                Toast.makeText(this@LoginActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun showSimpleProgressDialog(context: Context, title: String?, msg: String, isCancelable: Boolean) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg)
                mProgressDialog!!.setCancelable(isCancelable)
            }
            if (!mProgressDialog!!.isShowing) {
                mProgressDialog!!.show()
            }

        } catch (ie: IllegalArgumentException) {
            ie.printStackTrace()
        } catch (re: RuntimeException) {
            re.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog!!.isShowing) {
                    mProgressDialog!!.dismiss()
                    mProgressDialog = null
                }
            }
        } catch (ie: IllegalArgumentException) {
            ie.printStackTrace()

        } catch (re: RuntimeException) {
            re.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
