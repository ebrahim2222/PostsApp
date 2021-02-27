package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Model.Posts;
import com.example.myapplication.ViewModel.PostViewModel;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostsAdapter adapter;
    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecycler();

         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        PostViewModel viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        viewModel.getPosts();
        viewModel.mutableLiveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                Log.d(TAG, "hema onResponse: "+posts.get(1).getBody());
                adapter.setData(MainActivity.this,posts);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rv.setLayoutManager(manager);
        adapter = new PostsAdapter();
        binding.rv.setAdapter(adapter);
    }
}