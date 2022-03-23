package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.alo.eparts.storage.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    private Object MainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Thread thread=new Thread(){
           public void run()
           {
               try{
                sleep(4000);
               }catch(Exception e)
               {
                   e.printStackTrace();
               }finally {
                   Intent intent=new Intent(MainActivity.this,Intro1Activity.class);
                   startActivity(intent);
               }
               }

       };thread.start();
    }


//    protected void onResume()
//    {
//        super.onResume();
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String s1 = sh.getString("etuseremail", "");
//        String a = sh.getString("etuserpass", "");
//        Toast.makeText(this,s1,Toast.LENGTH_SHORT).show();
//        Intent intent=new Intent(MainActivity.this,navigationbar.class);
//        startActivity(intent);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn())
        {
            Intent intent=new Intent(this,navigationbar.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }



}