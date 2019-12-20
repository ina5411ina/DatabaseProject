package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button


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
//            ShowFragmentSearch()
            startActivity(Intent(this, testpage::class.java))
        }
        recommend_btn.setOnClickListener(){
            ShowFragmentRecommend()
        }
        like_btn.setOnClickListener(){
            ShowFragmentLike()
        }
    }

    fun ShowFragmentMain(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentMain()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
//    fun ShowFragmentSearch(){
//        val transaction = manager.beginTransaction()
//        val fragment = FragmentSearch()
//        transaction.replace(R.id.fragment_holder, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
    fun ShowFragmentRecommend(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentRecommend()
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

}
