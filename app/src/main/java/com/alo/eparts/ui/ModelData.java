package com.alo.eparts.ui;

public class ModelData {
    private  Integer id;
    private String state_name;

    public String getState_name() {
        return state_name;
    }
    public Integer getId() {
        return id;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public ModelData(String state_name,Integer id) {

        this.state_name = state_name;
        this.id = id;

    }
}
