package com.alo.eparts.RestApi;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    //GET TOKEN APISERVICE


    @Headers({
            "Accept:application/json",
            "Content-Type: application/json;charset=UTF-8",

    })
    @POST("/api/auth/login")
    Call<ResponseBody> getToken(@Body User user);

}
