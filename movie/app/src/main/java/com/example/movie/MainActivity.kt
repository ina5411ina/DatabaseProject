package com.example.movie


    import android.app.AlertDialog
    import android.content.Context
    import android.content.Intent
    import android.os.Bundle
    import android.text.Editable
    import android.text.TextWatcher
    import android.util.Log
    import android.view.*
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity
    import androidx.appcompat.view.menu.ActionMenuItemView
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.android.volley.Request
    import com.example.Adapter.GroupRecycleAdapter
    import com.example.Model_test.Food
    import com.example.Service_test.DataService
    import kotlinx.android.synthetic.main.activity_main.*
    import kotlinx.android.synthetic.main.activity_main.pic
    import kotlinx.android.synthetic.main.avtivity_user.*
    import kotlinx.android.synthetic.main.model.view.*
    import kotlinx.android.synthetic.main.test.*
    import okhttp3.*
    import org.json.JSONArray
    import org.json.JSONException
    import org.w3c.dom.Text
    import java.io.IOException
    import java.lang.StringBuilder
    import java.sql.Types.NULL


//import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
//    var mutableSet: MutableSet<Data> = mutableSetOf()
    var tag_1: String = "MainActivity"
    lateinit var adapter: GroupRecycleAdapter
    var flag:Int = 0

//    fun generateListView() {
//        adapter = GroupRecycleAdapter(this, DataService.groups)
//        gg.adapter = adapter
//        gg.layoutManager = LinearLayoutManager(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("@@@", "${tag_1}--onCreate()")




        val search = findViewById<SearchView>(R.id.searchbar)

        pic.setOnClickListener {
            var str = search.query
            val body = FormBody.Builder()
                .add("name", str.toString() + "%")
                .build()

//            print1.setText(str.toString())

            val client = OkHttpClient()
            val request = okhttp3.Request.Builder()
                .url("http://140.136.149.225:80/search movie.php")
                .post(body)
                .build()


            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
//                    oo.setText(e.message)
                }
                override fun onResponse(call: Call, response: Response) {
                    try {
                        val responseData = response.body()!!.string()
//Text.setText(responseData)
                        val json = JSONArray(responseData)


                        for (i in 0..19) {
                            if(!json.isNull(i)){
                                val jj = json.getJSONObject(i)
                                val title = jj.getString("primaryTitle".toString())
                                val release:String = jj.getString("startYear".toString())
//                                mutableSet.add( Data(title, release, "p1") )
//                                val tt: String = oo.text.toString()
                                val t:String = print1.text.toString()
                                    print1.setText(t+ "\n" + title.toString() + "\n" + release.toString())
                            }
                            else{
                                continue
                            }
                        }
                    } catch (e: JSONException) {
                        val tt: String = print1.text.toString()
                        print1.setText("no\n" + e.message)
                    }

                    flag = 1

                }
            })
//
//            if(flag == 1){
//                generateListView()
//            }
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

        fun startNextActivity(v: View) {
            var intent = Intent()

            when (v.id) {
                R.id.btn_main -> {
                    Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show()
                    intent.setClass(this, MainActivity::class.java)
                    startActivity(intent)

                }
                R.id.btn_movie -> {
                    Toast.makeText(this, "Movie", Toast.LENGTH_SHORT).show()
                    intent.setClass(this, movie::class.java)
                    startActivity(intent)
                }
                R.id.btn_tv -> {
                    Toast.makeText(this, "TV not yet", Toast.LENGTH_SHORT).show()
                    intent.setClass(this, user::class.java)
                    startActivity(intent)
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
