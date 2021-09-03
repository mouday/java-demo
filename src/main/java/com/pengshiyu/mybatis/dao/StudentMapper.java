package com.pengshiyu.mybatis.dao;

import com.pengshiyu.mybatis.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentDao {
    @Select("select * from students where id = #{id}")
    public Student getById(int id);

}
