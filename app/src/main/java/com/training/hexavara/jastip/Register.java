package com.training.hexavara.jastip;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Register extends AppCompatActivity {
    EditText etNama;
    EditText etEmail;
    EditText etPassword;
    String image, token;
    ImageButton register,back;
    String url = "http://prospace.id/jastipbasic/public/api/register";
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = (ImageButton)findViewById(R.id.registerbtn);
        back = (ImageButton)findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Register.this,SignUporLogin.class);
                startActivity(i1);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Register.this,login.class);
                startActivity(i1);
                finish();
            }
        });
    }

}
