package com.example.twitterjava;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static int ITEM_TYPE_1 = 1;
    public static int ITEM_TYPE_2 = 2;
    public static int ITEM_TYPE_3 = 3;

    private final Context context;
    private final ArrayList<Post> posts;
    private Lifecycle lifecycle;

    public FeedAdapter(Context context, ArrayList<Post> posts, Lifecycle lifecycle) {
        this.context = context;
        this.posts = posts;
        this.lifecycle = lifecycle;
    }

    @Override
    public int getItemViewType(int position) {
        if (posts.get(position).getPhoto2() != -1)
            return ITEM_TYPE_2;
        else if (posts.get(position).getVideoUrl() != null)
            return ITEM_TYPE_3;
        else
            return ITEM_TYPE_1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == ITEM_TYPE_1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
            return new PostViewHolder(view);
        } else if (viewType == ITEM_TYPE_3) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_video, parent, false);
            return new PostViewHolder3(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_2, parent, false);
            return new PostViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof PostViewHolder) {
            ((PostViewHolder) holder).iv_profile.setImageResource(posts.get(position).getProfile());
            ((PostViewHolder) holder).tv_fullname.setText(posts.get(position).getFullname());
            ((PostViewHolder) holder).iv_post.setImageResource(posts.get(position).getPhoto());

        }

        if (holder instanceof PostViewHolder2) {
            ((PostViewHolder2) holder).iv_profile.setImageResource(posts.get(position).getProfile());
            ((PostViewHolder2) holder).tv_fullname.setText(posts.get(position).getFullname());
            ((PostViewHolder2) holder).iv_post.setImageResource(posts.get(position).getPhoto());
            ((PostViewHolder2) holder).iv_post_2.setImageResource(posts.get(position).getPhoto2());

        }

        if (holder instanceof PostViewHolder3) {
            ((PostViewHolder3) holder).iv_profile.setImageResource(posts.get(position).getProfile());
            ((PostViewHolder3) holder).tv_fullname.setText(posts.get(position).getFullname());

            lifecycle.addObserver(((PostViewHolder3) holder).youTubePlayerView);
            ((PostViewHolder3) holder).youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = "OE8OQ16buDY";
                    youTubePlayer.loadVideo(videoId, 0);
                    youTubePlayer.pause();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_fullname;
        ShapeableImageView iv_post;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            iv_post = itemView.findViewById(R.id.iv_post);
        }
    }

    public static class PostViewHolder2 extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_fullname;
        ShapeableImageView iv_post;
        ShapeableImageView iv_post_2;

        public PostViewHolder2(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            iv_post = itemView.findViewById(R.id.iv_post);
            iv_post_2 = itemView.findViewById(R.id.iv_post_2);
        }
    }

    public static class PostViewHolder3 extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_fullname;
        YouTubePlayerView youTubePlayerView;

        public PostViewHolder3(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        }
    }
}
