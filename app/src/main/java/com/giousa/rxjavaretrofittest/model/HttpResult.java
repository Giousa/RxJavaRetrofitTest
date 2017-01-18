package com.giousa.rxjavaretrofittest.model;

/**
 * Description:
 * Author:Giousa
 * Date:2017/1/18
 * Email:65489469@qq.com
 */
public class HttpResult<T> {

//    {
//        "resultCode": 0,
//        "resultMessage": "成功",
//        "data": {}
//    }

//    private int resultCode;
//    private String resultMessage;
//
//    private T data;

    //用来模仿resultCode和resultMessage
    private int count;
    private int start;
    private int total;
    private String title;

    //用来模仿Data
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}