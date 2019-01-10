package com.chuiyan.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chuiyan.domain.Contact;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public DBHelper( Context context) {
        super(context,"contact", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table contact (id integer primary key autoincrement,name varchar(20),number varchar(20), address varchar(50))";
        //创建表结构
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //增
    public void insert(Contact contact){
        db = this.getReadableDatabase();
        String name =contact.getName();
        String number = contact.getNumber();
        String address = contact.getAddress();
        String sql="insert into contact (name,number,address) values('"+name+"','"+number+"','"+address+"')";
        db.execSQL(sql);
        db.close();
    }

    //改
    public void update(){
        db = this.getWritableDatabase();
        //db.update();
    }
    //查
    public Cursor query(){
       db = this.getReadableDatabase();
       String sql="select id _id,name,number,address from contact";
       Cursor cursor =db.rawQuery(sql,null);
        return cursor;
    }
    //删
    public void delete(int position){
        db = this.getReadableDatabase();
        String sql="delete from contact where id="+position;
        db.execSQL(sql);
        db.close();
    }

}
