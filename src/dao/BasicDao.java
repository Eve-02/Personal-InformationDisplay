package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class BasicDao<T> {

    private QueryRunner qr = new QueryRunner();

    // DML操作方法的通用方法
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtils.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JDBCUtils.close(null, null, connection);
        }
    }

    // 查询单列结果通用方法
    public T querySingle(String sql, Class<T> clazz, Object... parameters){
        Connection connection = null;

        try {
            connection = JDBCUtils.getConnection();
            return qr.query(connection, sql, new BeanHandler<>(clazz), parameters); // T Query
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, connection);
        }
    }

}