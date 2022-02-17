package com.alo.eparts.catalog;

public class BrandData {
    // string variables for our data
    // make sure that the variable name
    // must be similar to that of key value
    // which we are getting from our json file.
    private  String id;
    private String country_name;

    public String getId() {
        return id;
    }
    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setId(String id) {
        this.id = id;
    }


    public BrandData(String country_name,String id) {
        this.country_name = country_name;
        this.id = id;

    }
}
