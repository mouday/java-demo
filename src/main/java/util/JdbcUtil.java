package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
    // 需要配置c3p0-config.xml
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 返回连接对象
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 返回连接池对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 释放连接
    public static void releaseConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
