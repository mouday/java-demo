package com.pengshiyu.spring;

import com.pengshiyu.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        // 解析beans.xml 文件，生成对应的Bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)context.getBean("person");

    }
}
