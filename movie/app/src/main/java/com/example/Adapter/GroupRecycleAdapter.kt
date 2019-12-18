package com.example.Adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Model_test.Food
import com.example.movie.R

class GroupRecycleAdapter(val context: Context, val groups: List<Food>) :RecyclerView.Adapter<GroupRecycleAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupRecycleAdapter.Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.test, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return groups.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGroup(groups[position], context)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val gName: TextView = itemView.findViewById(R.id.Mtitle)
//        val img:ImageView = itemView.findViewById(R.id.moviepic)
//        val gReleasr:TextView = itemView.findViewById()
        val groupImage: ImageView = itemView.findViewById(R.id.groupimg)
        val groupName: TextView = itemView.findViewById(R.id.groupname)

        fun bindGroup(group: Food, context: Context) {
            val resourceId = context.resources.getIdentifier(group.pic, "drawable", context.packageName)
            groupImage.setImageResource(resourceId)
            groupName.text = group.name
            // 可多加此段程式以便追蹤
            Log.v("Test", group.name)
        }
    }

}

