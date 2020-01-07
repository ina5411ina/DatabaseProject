package com.example.tvchildren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.tvchildren.Class_GlobleVarable.Companion.IMDbUrl
import kotlinx.android.synthetic.main.activity_set_web_view.*

class SetWebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_web_view)
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        web.loadUrl(IMDbUrl)
    }
}
