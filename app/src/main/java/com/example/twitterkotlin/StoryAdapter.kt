package com.example.twitterkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StoryAdapter(private val context: Context, private val stories: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryViewHolder) {
            (holder as StoryViewHolder).iv_profile.setImageResource(
                stories[position].profile
            )
            (holder as StoryViewHolder).tv_fullname.setText(
                stories[position].fullname
            )
        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_fullname: TextView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.tv_fullname)
        }
    }
}