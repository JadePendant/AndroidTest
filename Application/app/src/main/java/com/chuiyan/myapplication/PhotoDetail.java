package com.chuiyan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoDetail extends Activity {
    private int position;
    private String text;
    private Button back;
    private Button last;
    private Button next;
    private TextView textView;
    private ImageView imageView;
    private TypedArray icons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_detail);
        imageView = findViewById(R.id.imageView);
        textView=findViewById(R.id.detail);
        back = findViewById(R.id.back);
        last = findViewById(R.id.last);
        next = findViewById(R.id.next);
        icons = getResources().obtainTypedArray(R.array.icons);
        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);
        imageView.setImageResource(icons.getResourceId(position,0));
        int t =position+1;
        text = "这是图片"+t;
        textView.setText(text);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position>0)
                {position--;
                    imageView.setImageResource(icons.getResourceId(position,0));
                    int temp = position+1;
                    text = "这是图片"+temp;
                    textView.setText(text);
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<icons.length()-1)
                {position++;
                    imageView.setImageResource(icons.getResourceId(position,0));
                    int temp= position+1;
                    text = "这是图片"+temp;
                    textView.setText(text);
                }
            }
        });
    }
}
