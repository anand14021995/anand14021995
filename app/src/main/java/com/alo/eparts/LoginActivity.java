package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
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
import com.alo.eparts.tokenmanager.TokenManager;
import com.google.gson.Gson;

import java.io.IOException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etuseremail , etuserpass;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etuseremail = (EditText)findViewById(R.id.editTextPhone);
        etuserpass = (EditText)findViewById(R.id.editTextPassword);
        sendButton = (Button)findViewById(R.id.buttonApply);

        //loginButton
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CallLoginService();
            }
        });
    }

    private void CallLoginService()
    {

        try {



                final String username = etuseremail.getText().toString();
                final String password = etuserpass.getText().toString();
                /*String jwt = Jwts.builder().claim("email",username).claim("password",password)
                        .signWith(SignatureAlgorithm.HS256, "secret".getBytes())
                        .compact();
                Log.v("JWT : - ",jwt);*/
                //Toast.makeText(LoginActivity.this,"Login Name--:"+jwt,Toast.LENGTH_SHORT).show();

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

                            Gson objGson = new Gson();
                            tokenResponse objResp = objGson.fromJson(ResponseJson, tokenResponse.class);
                            Toast.makeText(LoginActivity.this,objResp.getMsg(),Toast.LENGTH_SHORT).show();
                            //Log.v("JWT : - ",objResp.getMsg());
                            if(objResp.getMsg().equals("succesfully logged in"))
                            {
                                Intent intent=new Intent(LoginActivity.this,navigationbar.class);
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