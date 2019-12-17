package com.example.movie

    import android.app.AlertDialog
    import android.content.Intent
    import android.os.Bundle
    import android.util.Log
    import android.view.View
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import com.android.volley.Request
    import kotlinx.android.synthetic.main.activity_main.*
    import okhttp3.*
    import org.json.JSONArray
    import org.json.JSONException
    import org.w3c.dom.Text
    import java.io.IOException



//import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    var tag_1: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("@@@", "${tag_1}--onCreate()")

        btn_test.setOnClickListener{
            val body = FormBody.Builder()
                .add("mID","102")
                .build()
            val client = OkHttpClient()
            val req = okhttp3.Request.Builder()
                //webservice的位置
                .url("http://140.136.149.225:80/test.php")
                .post(body)
                .build()

            client.newCall(req).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {
                        Text.setText("first" +  e.message)
                }
                override fun onResponse(call: Call, response: Response) {
                    try {
                        val responseData = response.body()!!.string()
//Text.setText(responseData)
                        val json = JSONArray(responseData)

                        for(i in 0..2){
                            val jj = json.getJSONObject(i)
                            val owner = jj.getString("tconst")
                            val o:String = jj.getString("primaryTitle")
                            val tt:String = Text.toString()
                            Text.setText(tt.toString()+"\n"+owner+"\n"+o+"\n")

                        }
                    } catch (e: JSONException) {
                        val tt:String = Text.text.toString()
                        Text.setText("no\n" + e.message)
                    }
                }
            })
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("@@@", "${tag_1}--omStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("@@@", "${tag_1}--onResume()")
    }

    override fun onPause() {
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
