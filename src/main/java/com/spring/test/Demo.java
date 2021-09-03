package com.spring.test;


import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = (UserService) context.getBean("service");
        service.add();
        service.delete();

        /**
         * 执行结果
         *
         * --before--
         * add
         * --after--
         * --before--
         * delete
         * --after--
         */
    }
}
