package com.chuiyan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private TextView lab_login;
    private TextView lab_photo;
    private TextView lab_logs;
    private TextView lab_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        lab_login = findViewById(R.id.lab_login);
        lab_photo = findViewById(R.id.lab_photo);
        lab_logs = findViewById(R.id.lab_logs);
        lab_contact =findViewById(R.id.lab_contact);
        lab_login.setOnClickListener(this);
        lab_photo.setOnClickListener(this);
        lab_logs.setOnClickListener(this);
        lab_contact.setOnClickListener(this);
    }
    Intent intent = new Intent();
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lab_login:
                intent.setClass(Menu.this,Login.class);
                startActivity(intent);
                break;
            case R.id.lab_photo:
                intent.setClass(Menu.this,Photo.class);
                startActivity(intent);
                break;
            case R.id.lab_logs:
                intent.setClass(Menu.this,Logs.class);
                startActivity(intent);
                break;
            case R.id.lab_contact:
                intent.setClass(Menu.this,Contacter.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}
