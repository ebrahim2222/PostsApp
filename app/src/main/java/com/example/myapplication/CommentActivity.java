package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.myapplication.Model.Posts;

public class CommentActivity extends AppCompatActivity {
    Posts posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        getData();


    }

    private void getData() {
        Intent intent = getIntent();
        if(intent.hasExtra("posts"))
        {
             posts = intent.getExtras().getParcelable("posts");
        }
    }
}