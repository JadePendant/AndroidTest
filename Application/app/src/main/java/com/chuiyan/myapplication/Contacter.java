package com.chuiyan.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.chuiyan.domain.Contact;

public class Contacter extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private SimpleCursorAdapter simpleCursorAdapter;
    private ListView listView;
    private Button back;
    private Button add;
    private Bundle bundle;
    private Cursor cursor;
    private DBHelper dbHelper;
    private Contact contact=new Contact();
    private String form[]={"name","number","address"};
    private int[] to ={R.id.name,R.id.number,R.id.address};
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacter);
        builder = new AlertDialog.Builder(this);
        dbHelper= new DBHelper(this);
        cursor = dbHelper.query();
        back = findViewById(R.id.back);
        add = findViewById(R.id.add);
        back.setOnClickListener(this);
        add.setOnClickListener(this);
        listView =findViewById(R.id.listView);
        simpleCursorAdapter=new SimpleCursorAdapter(this,R.layout.contacter_item,cursor,form,to,0);
        listView.setAdapter(simpleCursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                builder.setTitle("警告")
                        .setIcon(R.drawable.alert)
                        .setMessage("真的要删除吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.delete((int)id);
                                cursor = dbHelper.query();
                                Toast.makeText(getApplicationContext(),"已删除",Toast.LENGTH_SHORT).show();
                                simpleCursorAdapter = new SimpleCursorAdapter(Contacter.this,R.layout.contacter_item,cursor,form,to,0);
                                listView.setAdapter(simpleCursorAdapter);
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
            }
        });

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
                intent.setClass(Contacter.this,AddContacter.class);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null)
        {
            bundle=data.getBundleExtra("contact");
            contact.setName(bundle.getString("name"));
            contact.setNumber(bundle.getString("number"));
            contact.setAddress(bundle.getString("address"));
            dbHelper.insert(contact);
            cursor = dbHelper.query();
            Toast.makeText(getApplicationContext(),"已添加",Toast.LENGTH_SHORT).show();
            simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.contacter_item,cursor,form,to,0);
            listView.setAdapter(simpleCursorAdapter);
        }

    }
}
