package com.example.diarytest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

//数据库：DbDiary
//表：Diary

public class MainActivity extends AppCompatActivity {

    private List<Diary> diaryList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.getDatabase();//创建数据库 DbDiary
        diaryList=DataSupport.findAll(Diary.class);

        DiaryAdapter adapter=new DiaryAdapter(MainActivity.this, R.layout.diary_item, diaryList);
        final ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        Button addDiary=(Button)findViewById(R.id.add_diary);//获取添加日记按钮
        addDiary.setOnClickListener(new View.OnClickListener(){//点击添加日记按钮后跳到AddDiaryActivity页面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AddDiaryActivity.class);
                startActivity(intent);
            }
        });//添加日记按钮处理完毕

        //如果点击列表中的某项，就跳转到观察日记页WatchDiaryAvtivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Diary diary=diaryList.get(position);
                Intent intent=new Intent(MainActivity.this, EditDiaryAvtivity.class);
                intent.putExtra("selectedDiary", diary);//将选中的日记对象传递到活动EditDiaryActivity
                startActivity(intent);
            }
        });//跳转到观察日记页WatchDiaryAvtivity处理结束

    }

}
