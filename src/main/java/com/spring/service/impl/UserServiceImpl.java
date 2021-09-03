package com.spring.serviceimpl;

import com.spring.dao.UserDao;
import com.spring.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
