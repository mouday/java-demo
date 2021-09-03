package com.pengshiyu.bean;

public class Book {
    private  String name;

    public Book(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "《" + this.name + "》";
    }
}
