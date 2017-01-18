package com.giousa.rxjavaretrofittest;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.giousa.rxjavaretrofittest.entity.MovieEntity;
import com.giousa.rxjavaretrofittest.http.MovieService;
import com.giousa.rxjavaretrofittest.utils.HttpMethods;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button mClickMeBN;
    @Bind(R.id.result_TV)
    TextView mResultTV;

    private final static String TAG = MainActivity.class.getSimpleName();
    String baseUrl = "https://api.douban.com/v2/movie/";
    private long mPreTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    public void getMovie() {

        mPreTime = System.currentTimeMillis();
        Log.d(TAG,"time 001 = "+ mPreTime);

//        obtainDataOne();
//        obtainDataTwo();
        obtainDataThree();




    }

    private void obtainDataOne() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MovieService movieService = retrofit.create(MovieService.class);
//        Call<MovieEntity> call = movieService.getTopMovie(0, 10);
//        call.enqueue(new Callback<MovieEntity>() {
//            @Override
//            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
//                Log.d(TAG,"onResponse="+response.body().toString());
//                long currentTime = System.currentTimeMillis();
//                Log.d(TAG,"time 002 = "+ currentTime+"   消耗时间："+(currentTime - mPreTime)+"毫秒");
//
//
//            }
//
//            @Override
//            public void onFailure(Call<MovieEntity> call, Throwable t) {
//                Log.d(TAG,"onFailure="+t.getMessage());
//
//            }
//        });
    }

    private void obtainDataTwo() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        MovieService movieService = retrofit.create(MovieService.class);
//
//        movieService.getTopMovie(0, 10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MovieEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG,"onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onNext(MovieEntity movieEntity) {
//                        Log.d(TAG,"onNext="+movieEntity.toString());
//                    }
//                });
    }



    private void obtainDataThree() {

        Subscriber<MovieEntity> subscriber = new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"three onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"three onError");
            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                Log.d(TAG,"three onNext="+movieEntity.toString());
            }
        };

        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);
    }


}
