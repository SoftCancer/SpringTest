package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: 获取JDBC连接
 * @author: YaoGuangXun
 * @date: 2018/11/13 16:17
 * @Version: 1.0
 */
public class JDBCUtils {


    static ComboPooledDataSource dataSource = null;

    /**
     *  通过静态代码块获取连接池数据源。
     *  1.获取数据源对象，并自动读取配置文件，配置文件名字默认：c3p0-config.xml
     **/
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSounce(){
        return dataSource;
    }

    /**
     * 获取数据库连接
     **/
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Connection conn, Statement st) {
        closeSt(st);
        closeConn(conn);
    }


    private static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void closeSt(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
