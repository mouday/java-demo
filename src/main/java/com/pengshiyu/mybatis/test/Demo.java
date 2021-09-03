package com.pengshiyu.mybatis.test;

import com.pengshiyu.mybatis.dao.StudentMapper;
import com.pengshiyu.mybatis.entity.Student;
import com.pengshiyu.mybatis.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StudentService studentService = (StudentService) context.getBean("studentService");

        Student student = studentService.getById(1);
        System.out.println(student);
    }
}
