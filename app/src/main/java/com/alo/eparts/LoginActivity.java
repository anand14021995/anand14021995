package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alo.eparts.RestApi.APIService;
import com.alo.eparts.RestApi.ApiClient;
import com.alo.eparts.RestApi.User;
import com.alo.eparts.RestApi.tokenResponse;
import com.alo.eparts.model.JWTToken;
import com.alo.eparts.remote.APICall;
import com.alo.eparts.remote.RetroClass;
import com.alo.eparts.storage.SharedPrefManager;
import com.alo.eparts.tokenmanager.TokenManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etuseremail , etuserpass;
    TextView forgotopen;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etuseremail = (EditText)findViewById(R.id.editTextPhone);
        etuserpass = (EditText)findViewById(R.id.editTextPassword);
        forgotopen = (TextView)findViewById(R.id.forgotopen);

        sendButton = (Button)findViewById(R.id.buttonApply);

        /*Forgot Clicked*/
        forgotopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

        //loginButton
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CallLoginService();
            }
        });
    }

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

//    protected void onResume()
//    {
//        super.onResume();
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String s1 = sh.getString("etuseremail", "");
//        String a = sh.getString("etuserpass", "");
//        etuseremail.setText(s1);
//        etuserpass.setText(String.valueOf(a));
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // Creating a shared pref object
//        // with a file name "MySharedPref"
//        // in private mode
//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        SharedPreferences.Editor myEdit = sharedPreferences.edit();
//
//        // write all the data entered by the user in SharedPreference and apply
//        myEdit.putString("etuseremail", etuseremail.getText().toString());
//        myEdit.putString("etuserpass", etuserpass.getText().toString());
//        myEdit.apply();
//    }

    private void CallLoginService()
    {

        try {



                final String username = etuseremail.getText().toString();
                final String password = etuserpass.getText().toString();
                APIService service = ApiClient.getClient().create(APIService.class);
            User user = new User();
            user.email = username;
            user.password = password;
            Call<ResponseBody> srvLogin = service.getToken(user);
            //Toast.makeText(LoginActivity.this,"Login Name--:"+srvLogin,Toast.LENGTH_SHORT).show();

            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful())
                    {

                        try {
                            String ResponseJson = response.body().string();
                            Toast.makeText(LoginActivity.this,ResponseJson,Toast.LENGTH_SHORT).show();
                            Gson objGson = new Gson();
                            tokenResponse objResp = objGson.fromJson(ResponseJson, tokenResponse.class);

                            Toast.makeText(LoginActivity.this, objResp.getMsg(),Toast.LENGTH_SHORT).show();

                            if(objResp.getMsg().equals("succesfully logged in"))
                            {
                                //Intent intent=new Intent(LoginActivity.this,navigationbar.class);
                                //startActivity(intent);
                                //finish();
                                SharedPrefManager.getInstance(LoginActivity.this).saveUser(objResp.getData());
                                Intent intent=new Intent(LoginActivity.this,navigationbar.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }

                            //Toast.makeText(LoginActivity.this,"Token Got Successfull",Toast.LENGTH_SHORT).show();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        Toast.makeText(LoginActivity.this,"system error occured please check your internet connection:",Toast.LENGTH_SHORT).show();
        }
    }
}