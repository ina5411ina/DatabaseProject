package com.example.tvchildren

import android.app.Application

class Class_GlobleVarable: Application() {
    companion object {
        var userName:String = "Kabi"
        var userbirth:String = "1999"
        var userfavorite:ArrayList<String> = arrayListOf()
        var userlikepage:ArrayList<String> = arrayListOf()


        var ttd:ArrayList<MovieData> = arrayListOf()
    }

    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}