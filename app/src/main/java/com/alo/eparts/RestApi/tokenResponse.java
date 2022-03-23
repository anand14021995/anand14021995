package com.alo.eparts.RestApi;

import com.alo.eparts.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class tokenResponse {
    private Data data;
    @SerializedName("token")
    private String token;

    @SerializedName("msg")
    @Expose
    private String msg;

//    private Data data;



    public tokenResponse(Data data, String token, String msg) {
        this.data = data;
        this.token = token;
        this.msg = msg;
    }

    public tokenResponse() {
        this.data = data;
        this.token = token;
        this.msg = msg;
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
    public Data getData()
    {
        return data;
    }


}
