package com.example.tvchildren

import android.app.Application
import android.widget.CheckBox

class Class_GlobleVarable: Application() {
    companion object {
        var userlikepage:ArrayList<String> = arrayListOf()

        var ttd:ArrayList<MovieData> = arrayListOf()

        //for FragmentMain
        //recycleview
        var imglist:MutableList<String> = mutableListOf()

        //if login
        var firstState = 0
        var login_tag = 0
        var Luid:Any = 0
        var userName:String = ""
        var userbirth:String = ""


        //EditUserPage
        var favoritelist:ArrayList<String> = arrayListOf()
        var btnboxState:MutableMap<String, Int> = mutableMapOf("Action" to 0, "Adventure" to 0, "Animation" to 0, "Comedy" to 0, "Crime" to 0, "Documentary" to 0, "Drama" to 0, "Fantasy" to 0, "Horror" to 0, "Mystery" to 0, "Romance" to 0, "Scifi" to 0, "Thriller" to 0)
    }

    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}