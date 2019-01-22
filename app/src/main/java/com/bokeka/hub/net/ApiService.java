package com.bokeka.hub.net;

import com.bokeka.hub.data.Blog;
import com.bokeka.hub.data.BlogCategory;
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
     * get blogs list
     * @param userId userId (default value = 0)
     * @param categoryId channel id
     * @return blog list
     */
    @GET("api/common/v1.0/showblogs/{user_id}/{category_id}")
    Single<Blog> fetchBlogsUnderCategory(@Path("user_id") int userId, @Path("category_id") int categoryId);

    @GET("api/common/v1.0/posts/")
    Observable<Posts> fetchActicles();

    /**
     * login
     * @return user token
     */
    @GET("api/v1.0/token")
    Observable<LoginTokenResp> basicLogin(@Header("Authorization") String authorization);

    /**
     * user info
     * @param token user authorization
     * @return user information
     */
    @GET("api/v1.0/user/info")
    Observable<UserResp> getUser(@Header("Authorization") String token);


    @GET("api/common/v1.0/categories/blog/")
    Observable<BlogCategory> getBlogCategories();

}

