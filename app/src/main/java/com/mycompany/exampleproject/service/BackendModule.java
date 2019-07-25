package com.mycompany.exampleproject.service;


import com.mycompany.exampleproject.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendModule {
    private static final long TIMEOUT_SECOUNDS = 20;
    public static Retrofit build() {
        String baseUrl = BuildConfig.URL;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client;
        client = new OkHttpClient.Builder()
                .addInterceptor(buildInterceptor())
                .addInterceptor(interceptor)
                .readTimeout(TIMEOUT_SECOUNDS, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_SECOUNDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECOUNDS, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private static Interceptor buildInterceptor() {
        return chain -> {
            Request original = chain.request();
            Request request = buildRequest(original);
            return chain.proceed(request);
        };
    }

    private static Request buildRequest(Request original) {
        return original.newBuilder()
                .header("Content-Type", "application/json")
                .method(original.method(), original.body()).build();
    }
}