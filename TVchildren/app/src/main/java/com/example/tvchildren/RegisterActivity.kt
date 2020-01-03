package com.example.tvchildren

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register.*

class RegisterActivity : AppCompatActivity() {

    internal var RegisterURL = ""
    private var etname: EditText? = null
    private var ethobby:EditText? = null
    private var etusername:EditText? = null
    private var etpassword:EditText? = null
    private var btnregister: Button? = null
    private var tvlogin: TextView? = null
    private var preferenceHelper: PreferenceHelper? = null
    private val RegTask = 1
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

//        preferenceHelper = PreferenceHelper(this)

//        if (preferenceHelper!!.getIsLogin()) {
//            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//            this.finish()
//        }

        var etname = findViewById<View>(R.id.etname)
        var etusername = findViewById<View>(R.id.etusername)
        var etpassword = findViewById<View>(R.id.etpassword)

        var btnregister = findViewById<View>(R.id.btn)
        var tvlogin = findViewById<TextView>(R.id.tvlogin)

        tvlogin.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

//        btnregister!!.setOnClickListener(){
//            try {
//                register()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            }
//        }
//
        testMain.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

//    @Throws(IOException::class, JSONException::class)
//    private fun register() {
//
//        showSimpleProgressDialog(this@RegisterActivity, null, "Loading...", false)
//
//        try {
//
//            Fuel.post(RegisterURL, listOf("name" to  etname!!.text.toString()
//                , "hobby" to  ethobby!!.text.toString()
//                , "username" to  etusername!!.text.toString()
//                , "password" to  etpassword!!.text.toString()
//            )).responseJson { request, response, result ->
//                Log.d("plzzzzz", result.get().content)
//                onTaskCompleted(result.get().content,RegTask)
//            }
//        } catch (e: Exception) {
//
//        } finally {
//
//        }
//
//    }
//
//    private fun onTaskCompleted(response: String, task: Int) {
//        Log.d("responsejson", response)
//        removeSimpleProgressDialog()
//        when (task) {
//            RegTask -> if (isSuccess(response)) {
//                saveInfo(response)
//                Toast.makeText(this@RegisterActivity, "Registered Successfully!", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
//                this.finish()
//            } else {
//                Toast.makeText(this@RegisterActivity, getErrorMessage(response), Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    fun saveInfo(response: String) {
//        preferenceHelper!!.putIsLogin(true)
//        try {
//            val jsonObject = JSONObject(response)
//            if (jsonObject.getString("status") == "true") {
//                val dataArray = jsonObject.getJSONArray("data")
//                for (i in 0 until dataArray.length()) {
//
//                    val dataobj = dataArray.getJSONObject(i)
//                    preferenceHelper!!.putName(dataobj.getString("name"))
//                    preferenceHelper!!.putHobby(dataobj.getString("hobby"))
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//    }
//
//    fun isSuccess(response: String): Boolean {
//        try {
//            val jsonObject = JSONObject(response)
//            return if (jsonObject.optString("status") == "true") {
//                true
//            } else {
//
//                false
//            }
//
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return false
//    }
//
//    fun getErrorMessage(response: String): String {
//        try {
//            val jsonObject = JSONObject(response)
//            return jsonObject.getString("message")
//
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return "No data"
//    }
//
//    fun showSimpleProgressDialog(context: Context, title: String?, msg: String, isCancelable: Boolean) {
//        try {
//            if (mProgressDialog == null) {
//                mProgressDialog = ProgressDialog.show(context, title, msg)
//                mProgressDialog!!.setCancelable(isCancelable)
//            }
//            if (!mProgressDialog!!.isShowing) {
//                mProgressDialog!!.show()
//            }
//
//        } catch (ie: IllegalArgumentException) {
//            ie.printStackTrace()
//        } catch (re: RuntimeException) {
//            re.printStackTrace()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//    }
//
//    fun removeSimpleProgressDialog() {
//        try {
//            if (mProgressDialog != null) {
//                if (mProgressDialog!!.isShowing) {
//                    mProgressDialog!!.dismiss()
//                    mProgressDialog = null
//                }
//            }
//        } catch (ie: IllegalArgumentException) {
//            ie.printStackTrace()
//
//        } catch (re: RuntimeException) {
//            re.printStackTrace()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//    }
//
}