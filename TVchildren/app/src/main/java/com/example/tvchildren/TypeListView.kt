package com.example.tvchildren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tvchildren.Class_GlobleVarable.Companion.ttd

class TypeListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typelistview)

        var test = arrayListOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        val tmp:MovieData = MovieData()
        for(i in 0..9) {
            tmp.name = "test-" + test[i]
            tmp.actors = "test-" + test[i]
            tmp.data = "test-" + test[i]
            tmp.url = "test-" + test[i]
            tmp.pic = "test-" + test[i]
            tmp.year = "test-" + test[i]
            ttd.add(tmp)
        }


        var listv = findViewById<ListView>(R.id.Type_ListView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, test)

        listv.adapter = adapter

        listv.setOnItemClickListener{parent, view, position, id ->
            if(position == 0){

            }
        }
    }
}
