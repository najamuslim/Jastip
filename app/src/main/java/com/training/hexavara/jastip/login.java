package com.training.hexavara.jastip;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    ImageButton login;
    EditText Email,Password;
    String email, password ,Name, Id, Token, Image;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    String url = "http://prospace.id/jastipbasic/public/api/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email=(EditText)findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.password);
        login = (ImageButton)findViewById(R.id.LoginBtn1);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               login();
            }
        });
        savelogin=sharedPreferences.getBoolean("savelogin",false);
        if(savelogin==true){
            Email.setText(sharedPreferences.getString("username",null));
            Password.setText(sharedPreferences.getString("usernrp",null));
            Intent i1 = new Intent(getApplicationContext(),Home.class);
            startActivity(i1);
            finish();
        }
    }
    public void login(){
        final String usrname = Email.getText().toString();
        final String usrpass = Password.getText().toString();
        if(usrname.length() == 0 || usrpass.length() == 0) {
            Toast.makeText(this,usrname+usrpass,Toast.LENGTH_LONG).show();
        }
        else {
            final RequestQueue requestQueue = Volley.newRequestQueue(login.this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            JSONObject User = null;
                            try {
                                User = new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                Name = User.getString("name");
                                Id = User.getString("username");
                                email = User.getString("email");
                                Image= User.getString("photo");
                                Token = User.getString("token");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            editor.putBoolean("savelogin", true);
                            editor.putString("username", usrname);
                            editor.putString("usernrp", usrpass);
                            editor.commit();
                            editor.apply();
                            Intent i1 = new Intent(login.this, Home.class);
                            startActivity(i1);
                            finish();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(login.this,error.toString(),Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                    requestQueue.stop();
                }
            }){
                protected Map<String, String> getParams() {
                    Map<String, String> MyData = new HashMap<String, String>();
                    MyData.put("username", usrname);
                    MyData.put("password",usrpass);
                    return MyData;
                }
            };
            requestQueue.add(stringRequest);
        }
    }

}
