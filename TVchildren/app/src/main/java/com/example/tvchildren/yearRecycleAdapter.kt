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




class yearRecycleAdapter(val context: Context, val yearly_pic_list: MutableList<ImgeUrl>) :RecyclerView.Adapter<yearRecycleAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):yearRecycleAdapter.Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.recyclemodel, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return yearly_pic_list.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGroup(yearly_pic_list[position], context)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val pic =itemView.findViewById<ImageView>(R.id.yearly_pic)

        fun bindGroup(yearly_pic_list:ImgeUrl, context: Context) {
            Glide.with(itemView.context).load(yearly_pic_list.pic).into(pic)
//            val resourceId = context.resources.getIdentifier(imglist.pic, "drawable", context.packageName)
//            pic.setImageResource(resourceId)
            // 可多加此段程式以便追蹤
            Log.v("Test", yearly_pic_list.pic)
        }
    }
}
