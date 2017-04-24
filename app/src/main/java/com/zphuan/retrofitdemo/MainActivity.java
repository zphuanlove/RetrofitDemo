package com.zphuan.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zphuan.retrofitdemo.http.GitHubService;
import com.zphuan.retrofitdemo.mode.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        final Call<User> mTestUser = service.getUser("zphuanlove");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //同步的方式
                    Response<User> response = mTestUser.execute();
                    User user = response.body();
                    Log.i("zph","user:"+user.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //异步的方式
        mTestUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User body = response.body();
                Log.i("zph","body:"+body.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("zph","error:"+t.toString());
            }
        });
    }
}
