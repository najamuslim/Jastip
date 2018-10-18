package com.training.hexavara.jastip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SetDeparture extends AppCompatActivity {
    ImageButton publish,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_departure);
        publish = (ImageButton) findViewById(R.id.publishbtn);
        back = (ImageButton)findViewById(R.id.backbtn3);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(SetDeparture.this, Home.class);
                startActivity(i1);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(SetDeparture.this, Home.class);
                startActivity(i1);
                finish();
            }
        });
    }
}
