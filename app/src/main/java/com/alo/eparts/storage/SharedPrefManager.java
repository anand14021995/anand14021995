package com.alo.eparts.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.alo.eparts.Data;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME="my_shared_preff";
    private static SharedPrefManager mInstance;
    private Context mCtx;
    private SharedPrefManager(Context mCtx)
    {
        this.mCtx=mCtx;
    }
    public static synchronized SharedPrefManager getInstance(Context mCtx)
    {
        if(mInstance==null)
        {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }
    public void saveUser(Data data)
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_email_id",data.getUser_email_id());
        editor.putString("user_name",data.getUser_name());
        editor.putInt("id",data.getId());
        editor.putInt("roleid",data.getRoleId());
        editor.apply();
    }
//    Logged in
    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id",-1)!=-1;
    }
    public Data getData()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        Data data =new Data(
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("user_email_id",null),
                sharedPreferences.getString("user_name",null),
                sharedPreferences.getInt("roleid",1));

        return data;
    }

    public void clear()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
