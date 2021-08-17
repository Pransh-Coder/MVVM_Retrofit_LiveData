package com.example.mvvm_retrofit_livedata

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import kotlin.collections.ArrayList
import kotlin.math.log

class RecyclerAdapterBooks(val bookListDataList: ArrayList<Items>) : RecyclerView.Adapter<RecyclerAdapterBooks.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(bookListDataList[position])
    }

    override fun getItemCount(): Int {
        Log.e("RecyclerAdapter", "getItemCount: "+bookListDataList.size )
        return bookListDataList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val tvTitle = itemView.tvTitle
        val tvPublisher = itemView.tvPublisher
        val tvDescription = itemView.tvDescription
        val thumbnailImageView = itemView.thumbImageView

        fun bindData(data:Items){
            tvTitle.text = data.volumeInfo.title
            tvPublisher.text = "Publisher: "+data.volumeInfo.publisher
            tvDescription.text = "Description: "+data.volumeInfo.description
            Log.e("RecyclerAdapter", "bindData: "+data.toString() )
            Log.e("RecyclerAdapter", "bindData imgLink: "+data.volumeInfo.imageLinks.smallThumbnail )

            val url = data?.volumeInfo?.imageLinks?.smallThumbnail
            Glide
                .with(thumbnailImageView)
                .load(url)
                .into(thumbnailImageView)

        }
    }
}