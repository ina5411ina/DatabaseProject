package com.example.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class movie : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_movie)
//    }
    val tag_1:String = "Hi~~~"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }
    override fun onStart() {
        super.onStart()
        Log.d("@@@", "${tag_1}--omStart()")
    }
    override fun onResume() {
        super.onResume()

        Log.d("@@@", "${tag_1}--onResume()")
    }
    override fun onPause(){
        super.onPause()
        Log.d("@@@", "${tag_1}--onsPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@@@", "${tag_1}--onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@@@", "${tag_1}--onDestroy()")
    }

    fun startNextActivity(v: View){
        var intent = Intent()


        when(v.id){
            R.id.btn_main -> {
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show()
                intent.setClass(this, MainActivity::class.java)
                startActivity(intent)

            }
            R.id.btn_movie-> {
                Toast.makeText(this, "Movie", Toast.LENGTH_SHORT).show()
                intent.setClass(this, movie::class.java)
                startActivity(intent)
            }
            R.id.btn_tv -> {
                Toast.makeText(this, "TV not yet", Toast.LENGTH_SHORT).show()
                intent.setClass(this, tv::class.java)
            }
            R.id.btn_keep -> {
                Toast.makeText(this, "keep not yet", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_recommend -> {
                Toast.makeText(this, "Recommend not yet", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
