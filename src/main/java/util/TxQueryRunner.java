package util;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int[] result = super.batch(con, sql, params);
        JdbcUtil.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con = JdbcUtil.getConnection();
        T result = super.query(con, sql, rsh, params);
        JdbcUtil.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        T result = super.query(con, sql, rsh);
        JdbcUtil.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql);
        JdbcUtil.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql, param);
        JdbcUtil.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql, params);
        JdbcUtil.releaseConnection(con);
        return result;
    }
}
