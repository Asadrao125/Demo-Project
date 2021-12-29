package com.technado.demoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technado.demoproject.R
import com.technado.demoproject.models.MovieModel

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    var context: Context? = null
    var movieModelList: List<MovieModel>? = null

    constructor(context: Context?, movieModelList: List<MovieModel>?) : super() {
        this.context = context
        this.movieModelList = movieModelList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.MyViewHolder, position: Int) {
        holder.tvTitle.setText(movieModelList?.get(position)?.title);
        Picasso.get().load(movieModelList?.get(position)?.thumbnailUrl).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
    }

    override fun getItemCount(): Int {
       /* if (movieModelList != null) {
            return movieModelList.size();
        } */
        return 0;
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var tvTitle: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            tvTitle = itemView.findViewById(R.id.tvTitle)
        }
    }
}