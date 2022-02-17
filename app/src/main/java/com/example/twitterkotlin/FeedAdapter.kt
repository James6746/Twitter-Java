package com.example.twitterjava

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterkotlin.Post
import com.example.twitterkotlin.R
import com.google.android.material.imageview.ShapeableImageView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FeedAdapter(
    private val context: Context,
    private val posts: ArrayList<Post>,
    private val lifecycle: Lifecycle
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    override fun getItemViewType(position: Int): Int {
        return if (posts[position].photo2 != -1) ITEM_TYPE_2 else if (posts[position].videoUrl != null) ITEM_TYPE_3 else ITEM_TYPE_1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == ITEM_TYPE_1) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
            PostViewHolder(view)
        } else if (viewType == ITEM_TYPE_3) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
            PostViewHolder3(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_2, parent, false)
            PostViewHolder2(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            holder.iv_profile.setImageResource(posts[position].profile)
            holder.tv_fullname.setText(posts[position].fullname)
            holder.iv_post.setImageResource(posts[position].photo)
        }
        if (holder is PostViewHolder2) {
            holder.iv_profile.setImageResource(posts[position].profile)
            holder.tv_fullname.setText(posts[position].fullname)
            holder.iv_post.setImageResource(posts[position].photo)
            holder.iv_post_2.setImageResource(posts[position].photo2)
        }
        if (holder is PostViewHolder3) {
            holder.iv_profile.setImageResource(posts[position].profile)
            holder.tv_fullname.setText(posts[position].fullname)
            lifecycle.addObserver(holder.youTubePlayerView)
            holder.youTubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = "OE8OQ16buDY"
                    youTubePlayer.loadVideo(videoId, 0f)
                    youTubePlayer.pause()
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_fullname: TextView
        var iv_post: ShapeableImageView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.tv_fullname)
            iv_post = itemView.findViewById(R.id.iv_post)
        }
    }

    class PostViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_fullname: TextView
        var iv_post: ShapeableImageView
        var iv_post_2: ShapeableImageView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.tv_fullname)
            iv_post = itemView.findViewById(R.id.iv_post)
            iv_post_2 = itemView.findViewById(R.id.iv_post_2)
        }
    }

    class PostViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_fullname: TextView
        var youTubePlayerView: YouTubePlayerView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.tv_fullname)
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view)
        }
    }

    companion object {
        var ITEM_TYPE_1 = 1
        var ITEM_TYPE_2 = 2
        var ITEM_TYPE_3 = 3
    }
}
