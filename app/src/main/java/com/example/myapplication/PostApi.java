package com.example.myapplication;

import com.example.myapplication.Model.Posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts")
    public Observable<List<Posts>> getPost();

}
