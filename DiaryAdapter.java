package com.example.diarytest01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 自定义适配器,将泛型指定为Diary类
 * Created by Admin on 2018/12/20.
 */

public class DiaryAdapter extends ArrayAdapter<Diary> {
    private int resourceId;

    public DiaryAdapter(Context context, int resource, List<Diary> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Diary diary=getItem(position);//获取当前的日记类对象
        View view= LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        //获取TextView
        TextView diary_title=(TextView) view.findViewById(R.id.diary_tile);//获取文本区
        diary_title.setText(diary.getTitle());//为其设置文字:当前日记类的标题
        return view;
    }
}
