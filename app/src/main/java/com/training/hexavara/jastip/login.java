package com.training.hexavara.jastip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class login extends AppCompatActivity {
    ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (ImageButton)findViewById(R.id.LoginBtn1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(login.this,Home.class);
                startActivity(i1);
                finish();
            }
        });
    }

}
