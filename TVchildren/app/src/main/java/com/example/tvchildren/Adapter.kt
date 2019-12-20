package com.example.tvchildren

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder> {
    private var context:Context

    constructor(context: Context): super(){
        this.context = context
    }

    private lateinit var data:List<Model>

    constructor(context: Context, data:List<Model>): super(){
        this.context = context
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val cell = LayoutInflater.from(context).inflate(R.layout.recyclemodel, parent, false)
        val viewHolder = ViewHolder(cell)
        cell.layoutParams.height = 150
        viewHolder.movie_pic = cell.findViewById(R.id.movie_pic)
        viewHolder.filmname_input = cell.findViewById(R.id.filmname_input)
        viewHolder.release_input = cell.findViewById(R.id.release_input)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val model = data[position]
        //Glide不確定
        Glide.with(context).load(model.pic).into(holder.movie_pic)
        holder.filmname_input.setText(model.filmname)
        holder.release_input.setText(model.release)

    }

    class ViewHolder : RecyclerView.ViewHolder{
        lateinit var movie_pic: ImageView
        lateinit var filmname_input: TextView
        lateinit var release_input: TextView

        constructor(itemView: View) : super(itemView)
    }

    class Model{
        var pic:String
        var filmname:String
        var release: String

        constructor(pic: String, filmname: String, release:String){
            this.pic = pic
            this.filmname = filmname
            this.release = release
        }
    }

}