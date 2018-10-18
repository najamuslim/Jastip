package com.training.hexavara.jastip;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLyout;
    private ActionBarDrawerToggle mToogle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageButton menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        menu =(ImageButton)findViewById(R.id.menu);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);

        mDrawerLyout=(DrawerLayout)findViewById(R.id.drawerlayout);
        mToogle= new ActionBarDrawerToggle(this,mDrawerLyout,R.string.open,R.string.close);

        mDrawerLyout.addDrawerListener(mToogle);
        mToogle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.home:
                Intent i1 = new Intent(profile.this,Home.class);
                startActivity(i1);
                finish();
            case R.id.logout:
                editor = sharedPreferences.edit();
                editor.putBoolean("savelogin",false);
                editor.apply();
                Intent i2 = new Intent(profile.this,login.class);
                startActivity(i2);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        if(id==R.id.home)
        {
            Intent i1 = new Intent(profile.this,Home.class);
            startActivity(i1);
            finish();
        }
        if(id==R.id.logout)
        {
            editor = sharedPreferences.edit();
            editor.putBoolean("savelogin",false);
            editor.apply();
            Intent i2 = new Intent(profile.this,login.class);
            startActivity(i2);
            finish();
        }

        return false;
    }
}
