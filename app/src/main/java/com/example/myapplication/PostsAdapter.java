package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Posts;
import com.example.myapplication.databinding.PostRawBinding;

import java.util.List;

import retrofit2.Callback;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyHolder> {

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostRawBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.post_raw,parent,false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Posts posts = body.get(position);
        holder.binding.setPost(posts);
    }

    @Override
    public int getItemCount() {
        return body!=null?body.size():0;
    }
    Context context;
    List<Posts> body;
    public void setData(Context context, List<Posts> body) {
        this.context = context;
        this.body = body;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        PostRawBinding binding;
        public MyHolder(@NonNull PostRawBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
