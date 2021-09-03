package com.pengshiyu.mybatis.dao.impl;

import com.pengshiyu.mybatis.dao.StudentMapper;
import com.pengshiyu.mybatis.entity.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public Student getById(int id) {
        return getSqlSession().selectOne("com.pengshiyu.mybatis.entity.StudentMapper.getById", id);
    }
}
