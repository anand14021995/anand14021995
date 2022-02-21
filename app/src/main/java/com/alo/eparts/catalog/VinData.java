package com.alo.eparts.catalog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VinData {
    private  Integer id;
    @SerializedName("business_name")
    @Expose
    private String business_name;
    @SerializedName("b_displayname")
    @Expose
    private String b_displayname;

    public String getBusiness_name() {
        return business_name;
    }
    public String getB_displayname() {
        return b_displayname;
    }
    public Integer getId() {
        return id;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }
    public void setB_displayname(String b_displayname) {
        this.b_displayname = b_displayname;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public VinData(String business_name,Integer id) {

        this.business_name = business_name;
        this.id = id;

    }
}
