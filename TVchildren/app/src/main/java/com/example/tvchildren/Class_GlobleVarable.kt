package com.example.tvchildren

import android.app.Application
import android.widget.CheckBox

class Class_GlobleVarable: Application() {
    companion object {
        var userName:String = "Kabi"
        var userbirth:String = "1999"

        var userlikepage:ArrayList<String> = arrayListOf()

        var ttd:ArrayList<MovieData> = arrayListOf()

        //EditUserPage
        var favoritelist:ArrayList<String> = arrayListOf()
        var btnboxState:ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    }

    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}