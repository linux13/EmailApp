package com.emailapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetInform extends AppCompatActivity {
        EditText getEmail,getSubjectt,getMessage;
        Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_inform);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initialize();

    }

    private void initialize() {

        getEmail = (EditText)findViewById(R.id.getemail);
        getMessage = (EditText)findViewById(R.id.getMessage);
        getSubjectt = (EditText)findViewById(R.id.getSubject);
        next = (Button)findViewById(R.id.next);

    }
    public void next(View v){

        nnext();

    }

    private void nnext() {

        String emaill,subjectt,msg;

        emaill = getEmail.getText().toString();
        subjectt = getSubjectt.getText().toString();
        msg = getMessage.getText().toString();
        Intent pass = new Intent(GetInform.this,ShowInformation.class);
        pass.putExtra("email",emaill);
        pass.putExtra("sub",subjectt);
        pass.putExtra("msg",msg);
        startActivity(pass);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.about){
           // Toast.makeText(this, "This is a simple Email App", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GetInform.this, About.class);

            startActivity(intent);

        }
        else if(id==android.R.id.home){

           back();
            return super.onOptionsItemSelected(item);

        }
        return true;
    }

    private void back() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
