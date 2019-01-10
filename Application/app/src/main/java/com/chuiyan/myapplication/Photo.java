package com.chuiyan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Photo extends Activity {
    private GridView gridView=null;
    private Button button;
    private  String[] names;
    private TypedArray icons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        icons = getResources().obtainTypedArray(R.array.icons);
        names = getResources().getStringArray(R.array.names);
        button = findViewById(R.id.back);
        gridView = findViewById(R.id.gridview);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<icons.length();i++)
        {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("icon",icons.getResourceId(i,0));
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.gridview_item,
                new String[]{"icon","name"},new int[]{R.id.icon_img,R.id.name_tv});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener((parent,view,position,id)->{
            Intent intent = new Intent();
            intent.setClass(Photo.this,PhotoDetail.class);
            intent.putExtra("position",position);
            startActivity(intent);
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
