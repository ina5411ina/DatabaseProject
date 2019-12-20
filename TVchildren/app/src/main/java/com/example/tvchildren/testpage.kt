package com.example.tvchildren

import ParksAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class testpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serach_page)
        setupView()
    }
    override fun onStart() {
        super.onStart()
        Log.d("@@@", "omStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("@@@", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@@@", "onsPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@@@", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@@@", "onDestroy()")
    }
    private fun setupView() {
        // adapter
        val adapter = ParksAdapter(supportFragmentManager)

        // LayoutInflater
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // viewPager
        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = adapter

        // tabLayout
        val tabLayout = findViewById<TabLayout>(R.id.tabs)

        // link tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager)
    }

}
