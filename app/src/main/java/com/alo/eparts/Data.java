package com.alo.eparts;

import com.alo.eparts.RestApi.tokenResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data extends tokenResponse {

    private String user_email_id;
    private String user_name;
    private int id;
    private int roleid;

    public Data(int id, String user_email_id, String user_name,int roleid) {

        this.user_email_id = user_email_id;
        this.user_name = user_name;
        this.id = id;
        this.roleid=roleid;
    }

    public int getRoleId()
    {
        return roleid;
    }
    public String getUser_email_id() {
        return user_email_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_email_id(String user_email_id) {
        this.user_email_id = user_email_id;
    }
    public int getId()
    {
        return id;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleId(int roleid) {
        this.roleid = roleid;
    }


}
