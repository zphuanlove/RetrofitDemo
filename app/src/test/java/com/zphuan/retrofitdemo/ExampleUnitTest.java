package com.zphuan.retrofitdemo;

import com.zphuan.retrofitdemo.http.GitHubService;
import com.zphuan.retrofitdemo.mode.User;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHttp() throws Exception{
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        final Call<User> mTestUser = service.getUser4Http("zphuanlove");
        //同步的方式
        Response<User> response = mTestUser.execute();
        User user = response.body();
        System.out.println(user.toString());
    }
}