package com.alo.eparts.remote;

import android.media.session.MediaSession;

import com.alo.eparts.model.JWTToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APICall {
    @FormUrlEncoded
    @POST("/api/auth/login")
    Call<JWTToken> userlogin(@Field("username") String username , @Field("userpass") String userpass);

}
