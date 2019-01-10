package com.chuiyan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContacter extends AppCompatActivity {
    private EditText name;
    private EditText number;
    private EditText address;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contacter);
        name=findViewById(R.id.name);
        number = findViewById(R.id.number);
        address =findViewById(R.id.address);
        add =findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                Bundle bundle =new Bundle();
                bundle.putString("name",name.getText().toString());
                bundle.putString("number",number.getText().toString());
                bundle.putString("address",address.getText().toString());
                intent.putExtra("contact",bundle);
                setResult(1,intent);
                finish();
            }
        });
    }
}
