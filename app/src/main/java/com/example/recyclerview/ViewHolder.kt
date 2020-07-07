package com.example.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val superheroName = view.findViewById(R.id.tvSuperhero) as TextView
    val realName = view.findViewById(R.id.tvRealName) as TextView
    val publisher = view.findViewById(R.id.tvPublisher) as TextView
    val avatar = view.findViewById(R.id.ivAvatar) as ImageView

    fun bind(superhero:Superhero, context: Context){
        superheroName.text = superhero.superhero
        realName.text = superhero.realName
        publisher.text = superhero.publisher
        avatar.loadUrl(superhero.photo)
        itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superhero, Toast.LENGTH_SHORT).show() })
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}