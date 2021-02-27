package com.example.myapplication;

import com.example.myapplication.Model.Posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private String baseUrl="https://jsonplaceholder.typicode.com/";
     private static PostClient Instance;
      PostApi postApi;
    public PostClient()
    {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postApi = retrofit.create(PostApi.class);
    }

    public static PostClient getInstance() {
        if(Instance == null)
        {
            Instance = new PostClient();
        }
        return Instance;
    }

    public Observable<List<Posts>> getPosts()
    {
        return postApi.getPost();
    }
}
