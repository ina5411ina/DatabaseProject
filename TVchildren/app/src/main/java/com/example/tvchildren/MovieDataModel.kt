package com.example.tvchildren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_data_model.*

class MovieDataModel() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_data_model)
        val data= intent.getSerializableExtra("Data") as MovieData

//        M_nameinput.setText(data.name)
//        M_timeinput.setText(data.year)
//        M_actorsinput.setText(data.actors)
//        M_datainput.setText(data.data)

//        M_nameinput.setText(Data.name)
//        M_timeinput.setText(Data.year)
//        M_actorsinput.setText(Data.actors)
//        M_datainput.setText(Data.data)

    }
}
