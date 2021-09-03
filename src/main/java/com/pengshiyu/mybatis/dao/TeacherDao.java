package com.pengshiyu.mybatis.dao;

import com.pengshiyu.mybatis.entity.Student;
import com.pengshiyu.mybatis.entity.Teacher;
import com.pengshiyu.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class TeacherDao {

    public Teacher selectOne(int id) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        Teacher teacher = session.selectOne(
                "com.pengshiyu.mybatis.entity.TeacherMapper.selectOneTeacher", id);
        session.close();
        return teacher;
    }

}
