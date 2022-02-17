package com.alo.eparts.RestApi;

import com.alo.eparts.remote.APICall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public  static final String BASE_URL="http://192.168.7.10:3000/";

    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
       /* if(retrofit==null)
        {*/
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
       /* }*/
        return retrofit;
    }




}
