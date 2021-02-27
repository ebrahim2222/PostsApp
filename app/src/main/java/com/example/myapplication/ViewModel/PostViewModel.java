package com.example.myapplication.ViewModel;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.Posts;
import com.example.myapplication.PostClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Posts>> mutableLiveData = new MutableLiveData<>();
    public void getPosts()
    {
        Observable<List<Posts>> observable = PostClient.getInstance().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<List<Posts>> observer = new Observer<List<Posts>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Posts> value) {
                mutableLiveData.setValue(value);           }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

}
