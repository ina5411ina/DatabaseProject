package GetData

import android.app.Activity
import android.util.Log
import android.view.View
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

fun Get_movie_data(Database:String, Name:String, Type:String, activity:Activity){
    val client = OkHttpClient()
    val url = "http://140.136.149.225:80/" + Database

    val body = FormBody.Builder()
        .add(Name,Type)
        .build()

    val request = Request.Builder()
        .url(url)
        .post(body)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.d("onFailure", e.message)
        }

        override fun onResponse(call: Call, response: Response) {
            activity.runOnUiThread(){
                Log.d("onResponse", "in here")

                var responseData = response.body()!!.string()
//                            var jsonarray = JSONArray(responseData)
//                            Log.i("seeRespond",response.body()!!.string())

                try {
                    var jsonarray = JSONArray(responseData)
                    for(i in 0..19){
                        if(!jsonarray.isNull(i)){
                            val json = jsonarray.getJSONObject(i)
//                            listadapter.addAll(json.getString("primaryTitle")+ "\t" +json.getString("startYear"))
                        }
                    }
                }catch (e: JSONException){
                    Log.d("Jsonerror ",e.message)
                }
            }
        }
    })
}