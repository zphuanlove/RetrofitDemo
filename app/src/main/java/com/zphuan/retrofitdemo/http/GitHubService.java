package com.zphuan.retrofitdemo.http;

import com.zphuan.retrofitdemo.mode.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zhongpeihuan on 2017/4/22.
 */

public interface GitHubService {
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @HTTP(method = "GET",path = "users/{user}",hasBody = false)
    Call<User> getUser4Http(@Path("user") String user);

    @POST("users/new")
    Call<User> createUser(@Body User user);
}
