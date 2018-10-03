package com.training.hexavara.jastip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignUporLogin extends AppCompatActivity {
    ImageButton login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upor_login);
        login = (ImageButton)findViewById(R.id.LoginBtn);
        signup = (ImageButton)findViewById(R.id.SignUpBtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(SignUporLogin.this, com.training.hexavara.jastip.login.class);
                startActivity(i1);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(SignUporLogin.this,Register.class);
                startActivity(i1);
                finish();
            }
        });
    }
}
