package com.chuiyan.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ant.liao.GifView;

public class LogsDetail extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Button back;
    private GifView gifView;
    private GifView gifLove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logs_detail);
        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.imageView);
        back = findViewById(R.id.back);
        gifView = findViewById(R.id.gifView);
        gifLove = findViewById(R.id.gifLove);
        gifView.setGifImage(R.drawable.jump);
        gifLove.setGifImage(R.drawable.love);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        Bundle bundle= intent.getBundleExtra("data");
            textView.setText(bundle.getString("text"));
            imageView.setImageResource(bundle.getInt("image"));
    }
}
