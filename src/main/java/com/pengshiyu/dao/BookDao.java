package com.pengshiyu.dao;

import com.pengshiyu.bean.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.TxQueryRunner;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new TxQueryRunner();

    public  List<Book> findAll() {
        String sql = "select * from tb_book";

        try {
            List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class));
            System.out.println(list);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Book> findByCategory(int category) {
        String sql = "select * from tb_book where category = ?";

        try {
            return qr.query(sql, new BeanListHandler<Book>(Book.class), category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
