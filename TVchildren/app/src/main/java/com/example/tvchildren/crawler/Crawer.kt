package com.example.tvchildren.crawler

import android.provider.DocumentsContract
import android.util.Log
import com.example.tvchildren.datapic.new
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import java.util.*

fun Crawler(url:String){
    val driver = ChromeDriver()

    driver.get(url)
    driver.findElementByClassName("slate")
        .findElement(By.tagName("A")).click()
    val a = driver.findElementByClassName("jw-media jw-reset")
        .findElement(By.tagName("viedo"))
        .findElement(By.className("jw-video jw-reset"))
        .getAttribute("src")

    Log.d("Url", a)


}
