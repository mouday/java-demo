package com.pengshiyu.mybatis.dao;

import com.pengshiyu.mybatis.entity.Student;
import com.pengshiyu.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class StudentDao {

    public List<Student> selectAll() throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<Student> students = session.selectList(
                "com.pengshiyu.mybatis.entity.StudentMapper.selectAllStudent");
        session.close();
        return students;
    }

}
