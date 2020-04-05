package com.vishal.buffershare.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 28/6/17.
 */

public class RetrofitClient {
    public static final String BASE_URL = "https://api.bufferapp.com/1/";
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
