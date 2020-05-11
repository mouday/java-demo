package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    // 配置文件路径
    private static String dbconfig = "dbconfig.properties";

    private static Properties prop = null;

    // 静态代码块只执行一次
    static {
        // 初始化数据库配置参数
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream(dbconfig);
            prop = new Properties();
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 加载驱动
        try{
            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                prop.getProperty("url"),
                prop.getProperty("username"),
                prop.getProperty("password")
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println(conn);
    }

}
