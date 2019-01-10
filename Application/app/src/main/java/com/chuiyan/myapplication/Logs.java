package com.chuiyan.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Logs extends AppCompatActivity implements View.OnClickListener {
    private TypedArray logsImage;
    private String[] logsName;
    private List<LogsData> logsDatas = new ArrayList<>();
    private LogsAdapter logsAdapter;
    private ListView listView;
    private Button back;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logs);
        back = findViewById(R.id.back);
        add = findViewById(R.id.add);
        back.setOnClickListener(this);
        add.setOnClickListener(this);
        initLogs();
        listView = findViewById(R.id.listView);
        logsAdapter = new LogsAdapter(Logs.this,R.layout.logs_item,logsDatas);
        listView.setAdapter(logsAdapter);
        Intent intent = new Intent();
        intent.setClass(Logs.this,LogsDetail.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle =new Bundle();
                bundle.putInt("image",logsDatas.get(position).getImage());
                bundle.putString("text",logsDatas.get(position).getText());
                intent.putExtra("data",bundle);
                startActivity(intent);
                logsAdapter.notifyDataSetChanged();
            }
        });
    }
    void initLogs(){
        logsImage = getResources().obtainTypedArray(R.array.logs_image);
        logsName = getResources().getStringArray(R.array.logs_name);
        for(int i=0;i<logsImage.length();i++)
        {
            LogsData logsData = new LogsData();
            logsData.setImage(logsImage.getResourceId(i,0));
            logsData.setText(logsName[i]);
            logsDatas.add(logsData);
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.back:
                finish();
                break;
            case R.id.add:
                Intent intent = new Intent();
                intent.setClass(Logs.this,AddLogs.class);
                startActivityForResult(intent,1);
                break;
                default:
                    break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null)
        {
            LogsData logsData = new LogsData();
            logsData.setImage(R.drawable.gif3);
            logsData.setText(data.getStringExtra("name"));
            logsDatas.add(logsData);
            logsAdapter.notifyDataSetChanged();
        }

    }
}
