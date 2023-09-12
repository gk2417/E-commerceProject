package com.example.mygrocerystore.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygrocerystore.R
import com.example.mygrocerystore.activities.ViewAllActivity
import com.example.mygrocerystore.models.HomeCategory

class HomeAdapter(var context: Context, var categoryList: List<HomeCategory>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_cat_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        Glide.with(context).load(categoryList[position].img_url).into(holder.catImg)
        holder.name.text = categoryList[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ViewAllActivity::class.java)
            intent.putExtra("type", categoryList[position].type)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var catImg: ImageView
        var name: TextView

        init {
            catImg = itemView.findViewById(R.id.home_cat_img)
            name = itemView.findViewById(R.id.cat_home_name)
        }
    }
}

