package com.zphuan.retrofitdemo;

import com.zphuan.retrofitdemo.http.GitHubService;
import com.zphuan.retrofitdemo.mode.User;

import org.junit.Test;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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
                baseUrl(GitHubService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        final Call<User> mTestUser = service.getUser4Http("zphuanlove");
        //同步的方式
        Response<User> response = mTestUser.execute();
        User user = response.body();
        System.out.println(user.toString());
    }

    @Test
    public void testFollowing() throws Exception{
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(GitHubService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<User>> userFollowings = service.getUserFollowings("zphuanlove", "id");
        Response<List<User>> response = userFollowings.execute();
        List<User> users = response.body();
        System.out.println("users:"+users.toString());
    }

    @Test
    public void testCreatUser() throws Exception{
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(GitHubService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        //由于user字段太多就不演示，直接new一个空对象
        Call<User> user = service.createUser(new User());
        //返回也是一个空对象
        User body = user.execute().body();
        System.out.println("user:"+body);
    }

    @Test
    public void testFormSubmit() throws Exception{
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(GitHubService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        //这里也是做一个模拟演示
        Call<User> user = service.updateUser("Jack","Lucy");
        //返回也是一个空对象
        User body = user.execute().body();
        System.out.println("user:"+body);
    }

    @Test
    public void testMultipart() throws Exception{
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(GitHubService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        GitHubService service = retrofit.create(GitHubService.class);
        File file = new File("app/src/ic_launcher.png");
        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody photo = RequestBody.create(mediaType,file);
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "description");
        Call<User> updateUser = service.updateUser(photo, description);
        Response<User> response = updateUser.execute();
        System.out.println("updateUser:"+response.body());
    }
}