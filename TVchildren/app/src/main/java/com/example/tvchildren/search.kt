package com.example.tvchildren

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ActionMenuView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search.*

class search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.tvchildren.R.layout.activity_search)
//        val toolbar: Toolbar = findViewById(com.example.tvchildren.R.id.toolbar)
//        setSupportActionBar(toolbar)

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
                intent.setClass(this, search::class.java)
                startActivity(intent)
            }
            com.example.tvchildren.R.id.btn_recommend -> {
                Toast.makeText(this, "Recommend not yet", Toast.LENGTH_SHORT).show()
            }
            com.example.tvchildren.R.id.btn_like ->{
                Toast.makeText(this, "like not yet", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
