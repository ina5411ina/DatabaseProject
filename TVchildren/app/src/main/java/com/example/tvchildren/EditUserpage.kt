package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.EditText
import com.example.tvchildren.Class_GlobleVarable.Companion.btnboxState
import com.example.tvchildren.Class_GlobleVarable.Companion.favoritelist
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

        checkBox1.isChecked = btnboxState[0] == 1
        checkBox2.isChecked = btnboxState[1] == 1
        checkBox3.isChecked = btnboxState[2] == 1
        checkBox4.isChecked = btnboxState[3] == 1
        checkBox5.isChecked = btnboxState[4] == 1
        checkBox6.isChecked = btnboxState[5] == 1
        checkBox7.isChecked = btnboxState[6] == 1
        checkBox8.isChecked = btnboxState[7] == 1
        checkBox9.isChecked = btnboxState[8] == 1
        checkBox10.isChecked = btnboxState[9] == 1
        checkBox11.isChecked = btnboxState[10] == 1
        checkBox12.isChecked = btnboxState[11] == 1
        checkBox13.isChecked = btnboxState[12] == 1



        checkBox1.setOnClickListener(){
            if(checkBox1.isChecked){
                favoritelist.add("Action")
                btnboxState[0] = 1
//                getFav(1, "Action")
                Log.d("Test", favoritelist[0])
            }
            else{
                favoritelist.remove("Action")
                btnboxState[0] = 0
//                getFav(2, "Action")
            }

        }
        checkBox2.setOnClickListener(){
            if(checkBox2.isChecked){
                favoritelist.add("Adventure")
                btnboxState[1] = 1
            }
            else{
                favoritelist.remove("Adventure")
                btnboxState[1] = 0
            }
        }

        checkBox3.setOnClickListener(){
            if(checkBox3.isChecked){
                favoritelist.add("Animation")
                btnboxState[2] = 1
            }
            else{
                favoritelist.remove("Animation")
                btnboxState[2] = 0
            }
        }

        checkBox4.setOnClickListener(){
            if(checkBox4.isChecked){
                favoritelist.add("Comedy")
                btnboxState[3] = 1
            }
            else{
                favoritelist.remove("Comedy")
                btnboxState[3] = 0
            }
        }

        checkBox5.setOnClickListener(){
            if(checkBox5.isChecked){
                favoritelist.add("Crime")
                btnboxState[4] = 1
            }
            else{
                favoritelist.remove("Crime")
                btnboxState[4] = 0
            }
        }

        checkBox6.setOnClickListener(){
            if(checkBox6.isChecked){
                favoritelist.add("Documentary")
                btnboxState[5] = 1
            }
            else{
                favoritelist.remove("Documentary")
                btnboxState[5] = 0
            }
        }

        checkBox7.setOnClickListener(){
            if(checkBox7.isChecked){
                favoritelist.add("Drama")
                btnboxState[6] = 1
            }
            else{
                favoritelist.remove("Drama")
                btnboxState[6] = 0
            }
        }

        checkBox8.setOnClickListener(){
            if(checkBox8.isChecked){
                favoritelist.add("Fantasy")
                btnboxState[7] = 1
            }
            else{
                favoritelist.remove("Fantasy")
                btnboxState[7] = 0
            }
        }

        checkBox9.setOnClickListener(){
            if(checkBox9.isChecked){
                favoritelist.add("Horror")
                btnboxState[8] = 1
            }
            else{
                favoritelist.remove("Horror")
                btnboxState[8] = 0
            }
        }

        checkBox10.setOnClickListener(){
            if(checkBox10.isChecked){
                favoritelist.add("Mystery")
                btnboxState[9] = 1
            }
            else{
                favoritelist.remove("Mystery")
                btnboxState[9] = 0
            }
        }

        checkBox11.setOnClickListener(){
            if(checkBox11.isChecked){
                favoritelist.add("Romance")
                btnboxState[10] = 1
            }
            else{
                favoritelist.remove("Romance")
                btnboxState[10] = 0
            }
        }

        checkBox12.setOnClickListener(){
            if(checkBox12.isChecked){
                favoritelist.add("Scifi")
                btnboxState[11] = 1
            }
            else{
                favoritelist.remove("Scifi")
                btnboxState[11] = 0
            }
        }

        checkBox13.setOnClickListener(){
            if(checkBox13.isChecked){
                favoritelist.add("Thriller")
                btnboxState[12] = 1
            }
            else{
                favoritelist.remove("Thriller")
                btnboxState[12] = 0
            }
        }

        finishbtn.setOnClickListener(){
            finish()
        }
    }
}
