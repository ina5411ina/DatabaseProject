package com.example.tvchildren.Kind_of_Adapter

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.transition.Transition
import com.example.tvchildren.R


class Adapter_pic(val context: Context, val imglist: MutableList<String>) :RecyclerView.Adapter<Adapter_pic.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Adapter_pic.Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.recyclemodel, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return imglist.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGroup(imglist[position], context)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val text1 = itemView.findViewById<TextView>(R.id.filmname_input)
//        val text2 = itemView.findViewById<TextView>(R.id.release_input)
        val pic = itemView.findViewById<ImageView>(R.id.movie_pic)

        fun bindGroup(imglist:String, context: Context) {
//            text1.text = imglist.name
//            text2.text = imglist.data
            Glide.with(context).load(imglist).into(pic)
//            val resourceId = context.resources.getIdentifier(imglist.pic, "drawable", context.packageName)
//            pic.setImageResource(resourceId)
            // 可多加此段程式以便追蹤
//            Log.v("Test", imglist.name)
        }
    }
}
