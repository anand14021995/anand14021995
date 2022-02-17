package com.alo.eparts.remote;

import com.alo.eparts.RestApi.APIService;
import com.alo.eparts.RestApi.ApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    private  static final String BASE_URL="http://192.168.7.10:3100/";
    private static Retrofit getRetrofitInstance()
    {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public  static  APIService getAPICall()
    {
        return ApiClient.getClient().create(APIService .class);
    }


}

