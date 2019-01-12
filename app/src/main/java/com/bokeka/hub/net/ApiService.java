package com.bokeka.hub.net;

import com.bokeka.hub.data.Blog;
import com.bokeka.hub.data.LoginTokenResp;
import com.bokeka.hub.data.Posts;
import com.bokeka.hub.data.UserResp;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public interface ApiService {
    /**
     * 拉取blogs列表
     * @param userId 用户Id, 未登陆填0
     * @param categoryId 栏目分类Id
     * @return Blog集合
     */
    @GET("api/common/v1.0/showblogs/{user_id}/{category_id}")
    Single<Blog> fetchBlogsUnderCategory(@Path("user_id") int userId, @Path("category_id") int categoryId);

    @GET("api/common/v1.0/posts/")
    Observable<Posts> fetchActicles();

    /**
     *  登录
     * @return
     */
    @GET("api/v1.0/token")
    Observable<LoginTokenResp> basicLogin(@Header("Authorization") String authorization);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @GET("api/v1.0/user/info")
    Observable<UserResp> getUser(@Header("Authorization") String token);
}

