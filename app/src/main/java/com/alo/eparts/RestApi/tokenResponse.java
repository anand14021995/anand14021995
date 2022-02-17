package com.alo.eparts.RestApi;

import com.google.gson.annotations.SerializedName;

public class tokenResponse {
    @SerializedName("token")
    private String token;

    @SerializedName("msg")
    private String msg;

    public tokenResponse()
    {

    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }


    public String getToken()
    {
        return  token;
    }
    public String getMsg()
    {
        return msg;
    }

}
