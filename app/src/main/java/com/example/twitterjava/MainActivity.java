package com.example.twitterjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerStory, recyclerFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        recyclerStory = findViewById(R.id.recyclerStory);
        recyclerStory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        recyclerFeed = findViewById(R.id.recyclerFeed);
        recyclerFeed.setLayoutManager(new GridLayoutManager(this, 1));


        refreshStoryAdapter(getAllStories());
        refreshFeedAdapter(getAllFeeds());
    }

    private void refreshStoryAdapter(ArrayList<Story> stories) {
        StoryAdapter adapter = new StoryAdapter(this, stories);
        recyclerStory.setAdapter(adapter);
    }

    void refreshFeedAdapter(ArrayList<Post> posts) {
        FeedAdapter adapter = new FeedAdapter(this, posts, getLifecycle());
        recyclerFeed.setAdapter(adapter);
    }

    ArrayList<Story> getAllStories() {
        ArrayList<Story> stories = new ArrayList<>();

        stories.add(new Story(R.drawable.profile1, "James"));
        stories.add(new Story(R.drawable.profile2, "Bob"));
        stories.add(new Story(R.drawable.profile3, "Mark"));
        stories.add(new Story(R.drawable.profile4, "Martha"));
        stories.add(new Story(R.drawable.profile5, "Elvis"));
        stories.add(new Story(R.drawable.james, "Clark"));
        stories.add(new Story(R.drawable.profile1, "James"));
        stories.add(new Story(R.drawable.profile2, "Bob"));
        stories.add(new Story(R.drawable.profile3, "Mark"));
        stories.add(new Story(R.drawable.profile4, "Martha"));
        stories.add(new Story(R.drawable.profile5, "Elvis"));
        stories.add(new Story(R.drawable.james, "Clark"));

        return stories;
    }

    ArrayList<Post> getAllFeeds() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(R.drawable.profile1, "James", R.drawable.photo, R.drawable.photo6));
        posts.add(new Post(R.drawable.profile2, "Bob", "" ));
        posts.add(new Post(R.drawable.profile3, "Mark", R.drawable.photo4));
        posts.add(new Post(R.drawable.profile4, "Martha", R.drawable.photo5, R.drawable.photo2));
        posts.add(new Post(R.drawable.profile5, "Elvis", R.drawable.photo2));
        posts.add(new Post(R.drawable.james, "Clark", R.drawable.photo6));
        posts.add(new Post(R.drawable.profile1, "James", R.drawable.photo));
        posts.add(new Post(R.drawable.profile2, "Bob", R.drawable.photo2));
        posts.add(new Post(R.drawable.profile3, "Mark", R.drawable.photo4));
        posts.add(new Post(R.drawable.profile4, "Martha", R.drawable.photo5));
        posts.add(new Post(R.drawable.profile5, "Elvis", R.drawable.photo6, R.drawable.photo4));
        posts.add(new Post(R.drawable.james, "Clark", R.drawable.photo6));
        posts.add(new Post(R.drawable.profile1, "James", R.drawable.photo, R.drawable.photo4));
        posts.add(new Post(R.drawable.profile2, "Bob", R.drawable.photo2));
        posts.add(new Post(R.drawable.profile3, "Mark", R.drawable.photo4));
        posts.add(new Post(R.drawable.profile4, "Martha", R.drawable.photo5));
        posts.add(new Post(R.drawable.profile5, "Elvis", R.drawable.photo6));
        posts.add(new Post(R.drawable.james, "Clark", R.drawable.photo6));

        return posts;
    }
}