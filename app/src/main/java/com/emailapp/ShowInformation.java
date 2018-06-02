package com.emailapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowInformation extends AppCompatActivity {
    TextView showEmail,showSubject,showMessage;
    Button correction;
    String email,subject,msg;
    String [] emaillist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initialize();

    }

    private void initialize() {

        showEmail = (TextView)findViewById(R.id.setemail);
        showSubject = (TextView)findViewById(R.id.setSubject);
        showMessage = (TextView)findViewById(R.id.setMessage);
        correction = (Button)findViewById(R.id.correction);

        setinfo();

    }
    public void correction(View v){
        Intent intent = new Intent(ShowInformation.this,GetInform.class);
        startActivity(intent);

    }

    private void setinfo() {

         email = getIntent().getStringExtra("email").toString();
       subject = getIntent().getStringExtra("sub").toString();
       msg = getIntent().getStringExtra("msg").toString();

         emaillist = email.split(",");

         showInfo();

    }

    private void showInfo() {

        showEmail.setText(email);
        showSubject.setText(subject);
        showMessage.setText(msg);

    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

        if(id==R.id.about) {

            Intent intent = new Intent(ShowInformation.this, About.class);

            startActivity(intent);

        }


        else if(id==R.id.send){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,emaillist);
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,msg);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"Select an email client"));

        }
        else if(id==android.R.id.home){

            Intent intent = new Intent(ShowInformation.this,GetInform.class);

            startActivity(intent);
        }
        return true;
    }
}
