package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alo.eparts.model.JWTToken;
import com.alo.eparts.remote.APICall;
import com.alo.eparts.remote.RetroClass;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity1 extends AppCompatActivity {

    private EditText username , userpass;
    private Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        username = (EditText)findViewById(R.id.editTextPhone);
        userpass = (EditText)findViewById(R.id.editTextPassword);
        sendButton = (Button)findViewById(R.id.buttonApply);

        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });
    }
}