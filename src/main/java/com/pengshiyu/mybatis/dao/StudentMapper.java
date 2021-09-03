package com.pengshiyu.mybatis.dao;

import com.pengshiyu.mybatis.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("select * from students where id = #{id}")
    public Student getById(int id);

}
