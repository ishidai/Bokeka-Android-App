package com.bokeka.hub.net;

import android.content.Context;
import android.text.TextUtils;

import com.bokeka.hub.utils.constans.Const;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class ApiClient {

    private static OkHttpClient okHttpClient;
    private static final int TIME_OUT = 60;
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (null == okHttpClient) {
            initOkhttp();
        }

        if (null == retrofit) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static void initOkhttp() {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

//                if (!TextUtils.isEmpty(PreNetUtils.getApiKey(context))) {
//                    requestBuilder.addHeader("Authorization", PreNetUtils.getApiKey(context));
//                }
                return chain.proceed(request);
            }
        });

        okHttpClient = httpClient.build();
    }
}

