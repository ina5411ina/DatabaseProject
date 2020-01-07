package com.example.tvchildren

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




class LoveAdapter(val context: Context, val movie: MutableList<Class_GlobleVarable.Companion.LoveData>) :RecyclerView.Adapter<LoveAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LoveAdapter.Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.recyclemodel, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return movie.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGroup(movie[position], context)
//        Log.d("Position", position.toString())
//        holder.itemView.setOnClickListener {
//            Log.d("Position", position.toString())
//        }
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val primary = itemView.findViewById<TextView>(R.id.primary_)
        val original = itemView.findViewById<TextView>(R.id.original_)
        var start = itemView.findViewById<TextView>(R.id.start_)
//        val text2 = itemView.findViewById<TextView>(R.id.release_input)
//        val pic = itemView.findViewById<ImageView>(R.id.movie_pic)

        fun bindGroup(movie:Class_GlobleVarable.Companion.LoveData, context: Context) {
            primary.text = movie.primary
            original.text = movie.original
            start.text = movie.startYear
//            text2.text = imglist.data
//            Glide.with(context).load(movie.pic).into(pic)
//            val resourceId = context.resources.getIdentifier(imglist.pic, "drawable", context.packageName)
//            pic.setImageResource(resourceId)
            // 可多加此段程式以便追蹤
//            Log.v("Test", imglist.name)
        }
    }
}
