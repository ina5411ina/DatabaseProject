package com.example.tvchildren

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tvchildren.Class_GlobleVarable.Companion.userBirth
import com.example.tvchildren.Class_GlobleVarable.Companion.userName

class FragmentLike_Sec :  Fragment(){

    val T = "FragmentLike_Sec"

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
        val inflate = inflater.inflate(R.layout.fragment_like__sec, container, false)

//        val userlike = inflate.findViewById<TextView>(R.id.UserLike)
//        val setfavorite = inflate.findViewById<Button>(R.id.Favorite)
        val layout = inflate.findViewById<View>(R.id.fragment_Like_Sec)
//        var username = inflate.findViewById<TextView>(R.id.username_input)
//        var userbirth = inflate.findViewById<TextView>(R.id.userbirth_input)
        var sethobby = inflate.findViewById<Button>(R.id.SetHobby)
        var lovemovie = inflate.findViewById<Button>(R.id.lovemovie)
//
//        username.setText(Class_GlobleVarable.userName)
//        userbirth.setText(Class_GlobleVarable.userBirth)

        Log.d("userName", userName)
        Log.d("userbirth", userBirth)


        //into checkView
        sethobby.setOnClickListener(){
            var intent = Intent(layout.context, EditUserpage::class.java)
            startActivity(intent)
        }
        lovemovie.setOnClickListener(){
            var intent = Intent(layout.context, LoveMovie::class.java)
            startActivity(intent)
        }



        return inflate
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
