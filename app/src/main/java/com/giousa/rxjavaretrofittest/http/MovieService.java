package com.giousa.rxjavaretrofittest.http;

import com.giousa.rxjavaretrofittest.entity.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Description:
 * Author:Giousa
 * Date:2017/1/6
 * Email:65489469@qq.com
 */
public interface MovieService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
