package com.pengshiyu.mybatis.service.impl;

import com.pengshiyu.mybatis.dao.StudentMapper;
import com.pengshiyu.mybatis.entity.Student;
import com.pengshiyu.mybatis.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student getById(int id) {
        return studentMapper.getById(id);
    }

}
