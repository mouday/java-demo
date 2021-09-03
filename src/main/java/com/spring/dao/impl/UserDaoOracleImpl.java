package com.spring.daoimpl;

import com.spring.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Oracle 获取用户信息");
    }
}
