package com.example.tvchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        var etusername = findViewById<EditText>(R.id.etusername)
        var etpassword = findViewById<EditText>(R.id.etpassword)
        var btnlogin = findViewById<Button>(R.id.btnlogin)
        var tvreg = findViewById<TextView>(R.id.tvreg)

        tvreg.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) 
        }

    }
}
