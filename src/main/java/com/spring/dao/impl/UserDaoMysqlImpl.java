package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql 获取用户信息");
    }
}
