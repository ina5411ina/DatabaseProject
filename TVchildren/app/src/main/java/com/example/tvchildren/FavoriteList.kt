package com.example.tvchildren

import java.io.Serializable

class Datafav: Serializable{
    var fav:ArrayList<String> = arrayListOf()

    init{
        fav.add("N/A")
    }
}

fun getFav(bb:Int, type:String){
    if(bb == 1){
        Datafav().fav.add(type)
    }
    else{
        Datafav().fav.remove(type)
    }
}