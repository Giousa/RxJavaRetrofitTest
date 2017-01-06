package com.giousa.rxjavaretrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.giousa.rxjavaretrofittest.entity.MovieEntity;
import com.giousa.rxjavaretrofittest.http.MovieService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button mClickMeBN;
    @Bind(R.id.result_TV)
    TextView mResultTV;

    private final static String TAG = MainActivity.class.getSimpleName();
    String baseUrl = "https://api.douban.com/v2/movie/";


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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<MovieEntity> call = movieService.getTopMovie(0, 10);
        call.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                Log.d(TAG,"onResponse="+response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                Log.d(TAG,"onFailure="+t.getMessage());

            }
        });
    }
}
