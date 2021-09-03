package com.pengshiyu.mybatis.dao;

import com.pengshiyu.mybatis.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao {
    @Select("select * from students")
    public List<Student> getList();
}
