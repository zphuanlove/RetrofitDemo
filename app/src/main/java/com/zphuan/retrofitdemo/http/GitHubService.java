package com.zphuan.retrofitdemo.http;

import com.zphuan.retrofitdemo.mode.User;
import com.zphuan.retrofitdemo.mode.Widget;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhongpeihuan on 2017/4/22.
 *
 */

public interface GitHubService {

    String BASE_URL="https://api.github.com/";

    /**
     * 根据用户名得到当前用户信息
     * @param user：GitHub用户名
     * @return
     */
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    /**
     * 通过Http注解的方式得到用户信息
     * @param user:GitHub用户名
     * @return
     */
    @HTTP(method = "GET",path = "users/{user}",hasBody = false)
    Call<User> getUser4Http(@Path("user") String user);

    /**
     * 得到某个用户在github上关注的用户
     * @param user：用户名
     * @param sort：参数sort  需要在调用的时候赋值
     * @return
     */
    @GET("users/{user}/following")
    Call<List<User>> getUserFollowings(@Path("user") String user, @Query("sort") String sort);

    /**
     * 得到某个公司下得所有用户
     * @return
     */
    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    /**
     * 在GitHub上创建用户
     * @param user
     * @return
     */
    @POST("users/new")
    Call<User> createUser(@Body User user);

    /**
     * 以表单的方式提交 POST提交 修改用户名
     * @return
     */
    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

    /**
     * 单文件上传
     * @param photo
     * @param description
     * @return
     */
    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    Call<List<Widget>> widgetList();
}
