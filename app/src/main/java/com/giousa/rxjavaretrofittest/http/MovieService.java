package com.giousa.rxjavaretrofittest.http;

import com.giousa.rxjavaretrofittest.entity.MovieEntity;
import com.giousa.rxjavaretrofittest.entity.SubjectBean;
import com.giousa.rxjavaretrofittest.model.HttpResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description:
 * Author:Giousa
 * Date:2017/1/6
 * Email:65489469@qq.com
 */
public interface MovieService {

    //方式1 和 方式2
//    @GET("top250")
//    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    //方式3
//    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    //方法4
    @GET("top250")
    Observable<HttpResult<List<SubjectBean>>> getTopMovie(@Query("start") int start, @Query("count") int count);


}
