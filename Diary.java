package com.example.diarytest01;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 日记类
 * Created by Admin on 2018/12/20.
 */

public class Diary extends DataSupport implements Serializable{
    private int id=0;
    private String title="";
    private String author="";
    private String date="";
    private String diaryContent="";

    public Diary() {
    }

    public Diary(String title, String author, String date, String diaryContent) {
        this.author = author;
        this.date = date;
        this.diaryContent = diaryContent;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
