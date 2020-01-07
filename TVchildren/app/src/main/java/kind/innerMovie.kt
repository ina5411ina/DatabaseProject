package kind

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.tvchildren.*
import com.example.tvchildren.Class_GlobleVarable.Companion.Luid
import kotlinx.android.synthetic.main.inner_movie.*
import kotlinx.android.synthetic.main.inner_movie.view.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class innerMovie:Fragment(){
    val T = "FragmentRecommend"

    override fun onAttach(context: Context) {
        Log.d(T, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(T, "onCreate")
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(T, "onCreateView")

        val inflate = inflater!!.inflate(R.layout.inner_movie, container, false)
        val tvtype = arrayListOf("Movie","Short","tvEpisode")

        val layout = inflate.findViewById<View>(R.id.Layout_movie)
        val list = inflate.findViewById<ListView>(R.id.searchlistview_movie)

        var listadapter = ArrayAdapter<String>(layout.context,android.R.layout.simple_spinner_dropdown_item,tvtype)
        list.adapter = listadapter

        var str:String
        listadapter.clear()

        layout.inner_search_movie.setOnClickListener(){
            Hide(layout.scrollview)
            str = layout.search.query.toString()
            if(str != ""){
                str = str + "%"
                Log.d("str",str)

                val client = OkHttpClient()
                val body = FormBody.Builder()
                    .add("name",str)
                    .add("genres", "%")
                    .build()
                val request = Request.Builder()
                    .url("http://140.136.149.225:80/search_movie.php")
                    .post(body)
                    .build()
                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("onFailure", e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        activity!!.runOnUiThread(){
                            Log.d("onResponse", "in here")

                            var responseData = response.body()!!.string()

                            try {
                                var jsonarray = JSONArray(responseData)
                                listadapter.clear()
                                for(i in 0..10){
                                    if(!jsonarray.isNull(i)){
                                        val json = jsonarray.getJSONObject(i)
                                        listadapter.addAll(json.getString("primaryTitle")+ "\n" + json.getString("originalTitle") + "\t" +json.getString("startYear"))
                                    }
                                }

                                list.setOnItemClickListener{parent, view, position, id ->
                                    var title = jsonarray.getJSONObject(position).get("primaryTitle").toString()
                                    var t = jsonarray.getJSONObject(position).get("tconst").toString()
                                    // 跳出視窗
                                    var build =  AlertDialog.Builder(layout.context)
                                    build.setTitle(title)
                                    build.setMessage("Go to IMDb")
                                    build.setPositiveButton("Go"){dialog, which ->
                                        //https://www.imdb.com/title/tt1475582/?ref_=nv_sr_srsg_0
                                        val a:String = "https://www.imdb.com/title/"
                                        val c:String = "/?ref_=nv_sr_srsg_0"
                                        var add = a + t + c
                                        Class_GlobleVarable.IMDbUrl = add
                                        var intent = Intent(layout.context, SetWebView::class.java)
                                        startActivity(intent)
                                    }
                                    val Dialog = build.create()
                                    Dialog.show()
                                    // 跳出視窗程式結束
                                    Log.d("tconst", t)
                                }

                                // 長按加入favorite
                                list.setOnItemLongClickListener { parent, view, position, id ->
                                    var tconst = jsonarray.getJSONObject(position).get("tconst").toString()
                                    var primary = jsonarray.getJSONObject(position).get("primaryTitle").toString()
                                    var original = jsonarray.getJSONObject(position).get("originalTitle").toString()
                                    var startYear = jsonarray.getJSONObject(position).get("startYear").toString()

                                    val body = FormBody.Builder()
                                        .add("id", Class_GlobleVarable.Luid.toString())
                                        .add("tconst", tconst)
                                        .add("primary", primary)
                                        .add("original", original)
                                        .add("startYear", startYear)
                                        .build()

                                    val body2 = FormBody.Builder()
                                        .add("id", Class_GlobleVarable.Luid.toString())
                                        .add("tconst", tconst)
                                        .build()

                                    if(Luid == 0){
                                        Toast.makeText(layout.context, "Please Login First", Toast.LENGTH_SHORT).show()
                                    }else{
                                        if(!Class_GlobleVarable.Lovelist.contains(tconst)){
                                            val client = OkHttpClient()

                                            val request = Request.Builder()
                                                .url("http://140.136.149.225:80/insertlove.php")
                                                .post(body)
                                                .build()

                                            client.newCall(request).enqueue(object : Callback {
                                                override fun onFailure(call: Call, e: IOException) {
                                                    Log.d("onFailure", e.message)
                                                }

                                                override fun onResponse(call: Call, response: Response) {
                                                    activity!!.runOnUiThread(){
                                                    }
                                                }
                                            })
                                            Class_GlobleVarable.Lovelist.add(tconst)
                                            Toast.makeText(layout.context, "Insert in to Favorite", Toast.LENGTH_SHORT).show()
                                        } else{
                                            val client = OkHttpClient()

                                            val request = Request.Builder()
                                                .url("http://140.136.149.225:80/deletelove.php")
                                                .post(body)
                                                .build()
                                            client.newCall(request).enqueue(object : Callback {
                                                override fun onFailure(call: Call, e: IOException) {
                                                    Log.d("onFailure", e.message)
                                                }

                                                override fun onResponse(call: Call, response: Response) {
                                                    activity!!.runOnUiThread(){
                                                    }
                                                }
                                            })
                                            Class_GlobleVarable.Lovelist.remove(tconst)
                                            Toast.makeText(layout.context, "You have deleted the Favorite", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                    true
                                }

                            }catch (e:JSONException){
                                Log.d("Jsonerror ",e.message)
                            }
                        }
                    }
                })
            }
            else{
                Toast.makeText(layout.context, "請輸入電影名子",Toast.LENGTH_SHORT).show()
            }

        }

        //return back
        layout.go_to_main.setOnClickListener(){
            var Main = Intent(layout.context, MainActivity::class.java)
            startActivity(Main)
        }

        // click every type
        val btn_action = inflate.findViewById<Button>(R.id.att_1)
        btn_action.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "Action")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_adventre = inflate.findViewById<Button>(R.id.att_2)
        btn_adventre.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "Adventure")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_animation = inflate.findViewById<Button>(R.id.att_3)
        btn_animation.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "animation")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_comedy = inflate.findViewById<Button>(R.id.att_4)
        btn_comedy.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "comedy")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_crime = inflate.findViewById<Button>(R.id.att_5)
        btn_crime.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "crime")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_documentary = inflate.findViewById<Button>(R.id.att_6)
        btn_documentary.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "documentary")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_drama = inflate.findViewById<Button>(R.id.att_7)
        btn_drama.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "drama")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_fantasy = inflate.findViewById<Button>(R.id.att_8)
        btn_fantasy.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "fantasy")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_horror = inflate.findViewById<Button>(R.id.att_9)
        btn_horror.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "horror")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_mystery = inflate.findViewById<Button>(R.id.att_10)
        btn_mystery.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "mystery")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_romance = inflate.findViewById<Button>(R.id.att_11)
        btn_romance.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "romance")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_scifi = inflate.findViewById<Button>(R.id.att_12)
        btn_scifi.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "scifi")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }

        val btn_thriller = inflate.findViewById<Button>(R.id.att_13)
        btn_thriller.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("kind", "Movie")
            intent.putExtra("Type", "thriller")
            intent.setClass(inflate.context, TypeListView::class.java)
            startActivity(intent)
        }
        return inflate
    }

    fun Hide(view:View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.INVISIBLE
        } else{
            View.INVISIBLE
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(T, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(T, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(T, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(T, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(T, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(T, "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d(T, "onDestroyView")
        super.onDestroyView()
    }
    override fun onDetach() {
        Log.d(T, "onDetach")
        super.onDetach()
    }

}