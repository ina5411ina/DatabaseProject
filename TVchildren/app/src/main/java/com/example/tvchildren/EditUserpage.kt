package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.tvchildren.Class_GlobleVarable.Companion.userfavorite
import kotlinx.android.synthetic.main.activity_edituserpage.*
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox1
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox10
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox11
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox12
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox13
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox2
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox3
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox4
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox5
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox6
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox7
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox8
import kotlinx.android.synthetic.main.activity_edituserpage.checkBox9
import kotlinx.android.synthetic.main.setfavorite.*

class EditUserpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edituserpage)

        var favoritelist:ArrayList<String> = arrayListOf()

        checkBox1.setOnClickListener(){
            if(checkBox1.isChecked){
                favoritelist.add("Action")
                getFav(1, "Action")
//                Log.d("Test", favoritelist[0])
            }
            else{
//                favoritelist.remove("Action")
                getFav(2, "Action")
            }

        }
        checkBox2.setOnClickListener(){
            if(checkBox2.isChecked){
                favoritelist.add("Adventure")
            }
            else{
                favoritelist.remove("Adventure")
            }
        }

        checkBox3.setOnClickListener(){
            if(checkBox3.isChecked){
                favoritelist.add("Animation")
            }
            else{
                favoritelist.remove("Animation")
            }
        }

        checkBox4.setOnClickListener(){
            if(checkBox4.isChecked){
                favoritelist.add("Comedy")
            }
            else{
                favoritelist.remove("Comedy")
            }
        }

        checkBox5.setOnClickListener(){
            if(checkBox5.isChecked){
                favoritelist.add("Crime")
            }
            else{
                favoritelist.remove("Crime")
            }
        }

        checkBox6.setOnClickListener(){
            if(checkBox6.isChecked){
                favoritelist.add("Documentary")
            }
            else{
                favoritelist.remove("Documentary")
            }
        }

        checkBox7.setOnClickListener(){
            if(checkBox7.isChecked){
                favoritelist.add("Drama")
            }
            else{
                favoritelist.remove("Drama")
            }
        }

        checkBox8.setOnClickListener(){
            if(checkBox8.isChecked){
                favoritelist.add("Fantasy")
            }
            else{
                favoritelist.remove("Fantasy")
            }
        }

        checkBox9.setOnClickListener(){
            if(checkBox9.isChecked){
                favoritelist.add("Horror")
            }
            else{
                favoritelist.remove("Horror")
            }
        }

        checkBox10.setOnClickListener(){
            if(checkBox10.isChecked){
                favoritelist.add("Mystery")
            }
            else{
                favoritelist.remove("Mystery")
            }
        }

        checkBox11.setOnClickListener(){
            if(checkBox11.isChecked){
                favoritelist.add("Romance")
            }
            else{
                favoritelist.remove("Romance")
            }
        }

        checkBox12.setOnClickListener(){
            if(checkBox12.isChecked){
                favoritelist.add("Scifi")
            }
            else{
                favoritelist.remove("Scifi")
            }
        }

        checkBox13.setOnClickListener(){
            if(checkBox13.isChecked){
                favoritelist.add("Thriller")
            }
            else{
                favoritelist.remove("Thriller")
            }
        }

        userfavorite = favoritelist

        finishbtn.setOnClickListener(){
            finish()
        }
    }
}
