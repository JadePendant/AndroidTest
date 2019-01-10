package com.chuiyan.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LogsAdapter extends ArrayAdapter {
    private  final int resourceId;
    public LogsAdapter(Context context, int resource,List<LogsData> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LogsData logsData = (LogsData) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView logsImage = view.findViewById(R.id.logs_image);//获取该布局内的图片视图
        TextView logsName =  view.findViewById(R.id.logs_name);//获取该布局内的文本视图
        logsImage.setImageResource(logsData.getImage());//为图片视图设置图片资源
        logsName.setText(logsData.getText());//为文本视图设置文本内容
        return view;
    }
}
