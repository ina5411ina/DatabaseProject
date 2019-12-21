package kind

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tvchildren.R
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

    fun getState():Int{
        return 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(T, "onCreateView")
        val inflate = inflater!!.inflate(R.layout.inner_movie, container, false)

        val testData = listOf<String>("11111", "22222","33333", "44444")


        val tvtype = arrayListOf("Movie","Short","tvEpisode")

        val layout = inflate.findViewById<View>(R.id.Layout_movie)
        val list = layout.findViewById<ListView>(R.id.searchlistview)
        val text123 = layout.findViewById<TextView>(R.id.text123)

        var listadapter = ArrayAdapter<String>(layout.context,android.R.layout.simple_spinner_dropdown_item,tvtype)
        list.adapter = listadapter

        var str:String
        listadapter.clear()

        layout.inner_search_movie.setOnClickListener(){
//            listadapter.addAll(testData)
//            Log.d("testData",listadapter.addAll(testData))
            str = layout.search.query.toString()
            if(str != ""){
                str = str + "%"
                Log.d("str",str)

                val client = OkHttpClient()
                val body = FormBody.Builder()
                    .add("name",str)
                    .add("genre", "%Horror%")
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
                        Log.d("onResponse", "in here")

                        var responseData = response.body()!!.string()
//                        var jsonarray = JSONArray(responseData)
//                        Log.i("seeRespond",response.body()!!.string())

                        try {
                            var jsonarray = JSONArray(responseData)
                            for(i in 0..19){
                                if(!jsonarray.isNull(i)){
                                    val json = jsonarray.getJSONObject(i)
                                    listadapter.addAll(json.getString("primaryTitle")+ "\t" +json.getString("startYear"))
                                }
                            }

                        }catch (e:JSONException){
                            Log.d("Jsonerror ",e.message)
                        }


                    }

                })
            }
            else{
                Toast.makeText(layout.context, "請輸入電影名子",Toast.LENGTH_SHORT).show()
            }

        }
        return inflate
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