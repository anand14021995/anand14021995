package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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




}