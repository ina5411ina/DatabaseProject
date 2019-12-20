package com.example.tvchildren

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvchildren.search
import kotlinx.android.synthetic.main.activity_search.*
import okhttp3.FormBody
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.time.Instant
import java.util.*
import com.example.tvchildren.Adapter
import kotlinx.android.synthetic.main.recycleview.*


val list = mutableListOf<Adapter.Model>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



    fun startNextActivity(v: View) {
        var intent = Intent()

        when (v.id) {
            com.example.tvchildren.R.id.btn_main -> {
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show()
                intent.setClass(this, MainActivity::class.java)
                startActivity(intent)

            }
            com.example.tvchildren.R.id.btn -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                intent.setClass(this, test::class.java)
                startActivity(intent)
            }
            com.example.tvchildren.R.id.btn_recommend -> {
                Toast.makeText(this, "Recommend not yet", Toast.LENGTH_SHORT).show()
                intent.setClass(this, test_rv::class.java)
                startActivity(intent)
            }
            com.example.tvchildren.R.id.btn_like ->{
                Toast.makeText(this, "like not yet", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
