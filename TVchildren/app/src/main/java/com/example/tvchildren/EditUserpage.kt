package com.example.tvchildren

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tvchildren.Class_GlobleVarable.Companion.Luid
import com.example.tvchildren.Class_GlobleVarable.Companion.btnboxState
import com.example.tvchildren.Class_GlobleVarable.Companion.favoritelist
import kotlinx.android.synthetic.main.activity_edituserpage.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import kotlin.concurrent.timer


class EditUserpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edituserpage)

        checkBox1.isChecked = btnboxState["Action"] == 1
        checkBox2.isChecked = btnboxState["Adventure"] == 1
        checkBox3.isChecked = btnboxState["Animation"] == 1
        checkBox4.isChecked = btnboxState["Comedy"] == 1
        checkBox5.isChecked = btnboxState["Crime"] == 1
        checkBox6.isChecked = btnboxState["Documentary"] == 1
        checkBox7.isChecked = btnboxState["Drama"] == 1
        checkBox8.isChecked = btnboxState["Fantasy"] == 1
        checkBox9.isChecked = btnboxState["Horror"] == 1
        checkBox10.isChecked = btnboxState["Mystery"] == 1
        checkBox11.isChecked = btnboxState["Romance"] == 1
        checkBox12.isChecked = btnboxState["Scifi"] == 1
        checkBox13.isChecked = btnboxState["Thriller"] == 1



        checkBox1.setOnClickListener(){
            if(checkBox1.isChecked){
                favoritelist.add("Action")
                btnboxState["Action"] = 1
//                getFav(1, "Action")
                Log.d("Test", favoritelist[0])
            }
            else{
                favoritelist.remove("Action")
                btnboxState["Action"] = 0
//                getFav(2, "Action")
            }

        }

        checkBox2.setOnClickListener(){
            if(checkBox2.isChecked){
                favoritelist.add("Adventure")
                btnboxState["Adventure"] = 1
            }
            else{
                favoritelist.remove("Adventure")
                btnboxState["Adventure"] = 0
            }
        }

        checkBox3.setOnClickListener(){
            if(checkBox3.isChecked){
                favoritelist.add("Animation")
                btnboxState["Animation"] = 1
            }
            else{
                favoritelist.remove("Animation")
                btnboxState["Animation"] = 0
            }
        }

        checkBox4.setOnClickListener(){
            if(checkBox4.isChecked){
                favoritelist.add("Comedy")
                btnboxState["Comedy"] = 1
            }
            else{
                favoritelist.remove("Comedy")
                btnboxState["Comedy"] = 0
            }
        }

        checkBox5.setOnClickListener(){
            if(checkBox5.isChecked){
                favoritelist.add("Crime")
                btnboxState["Crime"] = 1
            }
            else{
                favoritelist.remove("Crime")
                btnboxState["Crime"] = 0
            }
        }

        checkBox6.setOnClickListener(){
            if(checkBox6.isChecked){
                favoritelist.add("Documentary")
                btnboxState["Documentary"] = 1
            }
            else{
                favoritelist.remove("Documentary")
                btnboxState["Documentary"] = 0
            }
        }

        checkBox7.setOnClickListener(){
            if(checkBox7.isChecked){
                favoritelist.add("Drama")
                btnboxState["Drama"] = 1
            }
            else{
                favoritelist.remove("Drama")
                btnboxState["Drama"] = 0
            }
        }

        checkBox8.setOnClickListener(){
            if(checkBox8.isChecked){
                favoritelist.add("Fantasy")
                btnboxState["Fantasy"] = 1
            }
            else{
                favoritelist.remove("Fantasy")
                btnboxState["Fantasy"] = 0
            }
        }

        checkBox9.setOnClickListener(){
            if(checkBox9.isChecked){
                favoritelist.add("Horror")
                btnboxState["Horror"] = 1
            }
            else{
                favoritelist.remove("Horror")
                btnboxState["Horror"] = 0
            }
        }

        checkBox10.setOnClickListener(){
            if(checkBox10.isChecked){
                favoritelist.add("Mystery")
                btnboxState["Mystery"] = 1
            }
            else{
                favoritelist.remove("Mystery")
                btnboxState["Mystery"] = 0
            }
        }

        checkBox11.setOnClickListener(){
            if(checkBox11.isChecked){
                favoritelist.add("Romance")
                btnboxState["Romance"] = 1
            }
            else{
                favoritelist.remove("Romance")
                btnboxState["Romance"] = 0
            }
        }

        checkBox12.setOnClickListener(){
            if(checkBox12.isChecked){
                favoritelist.add("Scifi")
                btnboxState["Scifi"] = 1
            }
            else{
                favoritelist.remove("Scifi")
                btnboxState["Scifi"] = 0
            }
        }

        checkBox13.setOnClickListener(){
            if(checkBox13.isChecked){
                favoritelist.add("Thriller")
                btnboxState["Thriller"] = 1
            }
            else{
                favoritelist.remove("Thriller")
                btnboxState["Thriller"] = 0
            }
        }

        hobby_finishbtn.setOnClickListener(){

            Log.d("favoritelist_size", (favoritelist.size).toString())
            Log.d("uid", Luid.toString())
            for( i in favoritelist) {
                Log.d("favoritelist_size", i)
            }
            for( i in favoritelist){
                val client = OkHttpClient()
                val body = FormBody.Builder()
                    .add("id",Luid.toString())
                    .add("genres", i)
                    .build()
                val request = Request.Builder()
                    .url("http://140.136.149.225:80/inserthobby.php")
                    .post(body)
                    .build()

                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("onFailure", e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        runOnUiThread() {
                            Log.d("onResponse", "In here" )
                        }
                    }
                })

            }
            finish()
        }
    }
}
