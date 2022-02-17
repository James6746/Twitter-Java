package com.example.twitterkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterjava.FeedAdapter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this, chats)
        recyclerStory.adapter = adapter
    }

    fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this, posts, lifecycle)
        recyclerFeed.adapter = adapter
    }

    fun getAllStories(): ArrayList<Story> {
        val stories: ArrayList<Story> = ArrayList()

        stories.add(Story(R.drawable.profile1, "James"))
        stories.add(Story(R.drawable.profile2, "Bob"))
        stories.add(Story(R.drawable.profile3, "Mark"))
        stories.add(Story(R.drawable.profile4, "Martha"))
        stories.add(Story(R.drawable.profile5, "Elvis"))
        stories.add(Story(R.drawable.james, "Clark"))
        stories.add(Story(R.drawable.profile1, "James"))
        stories.add(Story(R.drawable.profile2, "Bob"))
        stories.add(Story(R.drawable.profile3, "Mark"))
        stories.add(Story(R.drawable.profile4, "Martha"))
        stories.add(Story(R.drawable.profile5, "Elvis"))
        stories.add(Story(R.drawable.james, "Clark"))


        return stories
    }

    fun getAllFeeds(): java.util.ArrayList<Post> {
        val posts = java.util.ArrayList<Post>()
        posts.add(Post(R.drawable.profile1, "James", R.drawable.photo, R.drawable.photo6))
        posts.add(Post(R.drawable.profile2, "Bob", ""))
        posts.add(Post(R.drawable.profile3, "Mark", R.drawable.photo4))
        posts.add(Post(R.drawable.profile4, "Martha", R.drawable.photo5, R.drawable.photo2))
        posts.add(Post(R.drawable.profile5, "Elvis", R.drawable.photo6))
        posts.add(Post(R.drawable.james, "Clark", R.drawable.photo6))
        posts.add(Post(R.drawable.profile1, "James", R.drawable.photo))
        posts.add(Post(R.drawable.profile2, "Bob", R.drawable.photo2))
        posts.add(Post(R.drawable.profile3, "Mark", R.drawable.photo4))
        posts.add(Post(R.drawable.profile4, "Martha", R.drawable.photo5))
        posts.add(Post(R.drawable.profile5, "Elvis", R.drawable.photo6, R.drawable.photo4))
        posts.add(Post(R.drawable.james, "Clark", R.drawable.photo6))
        posts.add(Post(R.drawable.profile1, "James", R.drawable.photo, R.drawable.photo4))
        posts.add(Post(R.drawable.profile2, "Bob", R.drawable.photo2))
        posts.add(Post(R.drawable.profile3, "Mark", R.drawable.photo4))
        posts.add(Post(R.drawable.profile4, "Martha", R.drawable.photo5))
        posts.add(Post(R.drawable.profile5, "Elvis", R.drawable.photo6))
        posts.add(Post(R.drawable.james, "Clark", R.drawable.photo6))
        return posts
    }
}