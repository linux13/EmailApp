package com.emailapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {
        TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        txt = (TextView)findViewById(R.id.show);
        String s = "This App is developed by Md Asfak Hussain Shafi \nThis is an Test Application \nIt's built only for learning purposes ";
        txt.setText(s);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            Intent intent = new Intent(About.this,GetInform.class);
            startActivity(intent);
        }
        return true;
    }
    }
