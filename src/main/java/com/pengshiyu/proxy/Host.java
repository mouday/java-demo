package com.pengshiyu.proxy;

public class Host implements IRent{
    @Override
    public void rent() {
        System.out.println("房东租房");
    }
}
