package com.util;

import com.ygx.jdbcconnection.ResultSetHandl;

import java.sql.*;

/**
 * @Description: 模拟DBUtils 的update和Query方法
 * @author: YaoGuangXun
 * @date: 2018/11/13 14:29
 * @Version: 1.0
 */
public class DBUtils {

    /**
     * 以参数个数为例，通用增删该方法
     **/
    public void Update(String sql, Object... args) {

        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
                System.out.println("参数位置：" + (i + 1) + "参数：" + args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 以问号个数为例，实现通用增删该方法，方式参数个数大于问号数。
     **/
    public static void ExtUpdate(String sql, Object... args) {

        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 2.获取ParameterMetaData对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            // 3.通过ParameterMetaData对象，获取预编译SQL语句中占位符参数的个数
            int count = parameterMetaData.getParameterCount();
            // 4.遍历参数，并设置参数
            for (int i = 0; i < count; i++) {
                preparedStatement.setObject(i + 1, args[i]);
                System.out.println("参数位置：" + (i + 1) + "参数：" + args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 以问号个数为例，实现通用查询方法，方式参数个数大于问号数。
     **/
    public static void Query(String sql, ResultSetHandl resultSetHandl, Object... args) {

        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 2.获取ParameterMetaData对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            // 3.通过ParameterMetaData对象，获取预编译SQL语句中占位符参数的个数
            int count = parameterMetaData.getParameterCount();
            // 4.遍历参数，并设置参数
            for (int i = 0; i < count; i++) {
                preparedStatement.setObject(i + 1, args[i]);
                System.out.println("参数位置：" + (i + 1) + "参数：" + args[i]);
            }
            // 5.获取查询结果。
            ResultSet resultSet = preparedStatement.executeQuery();
            // 6.把结果放进匿名内部类中
            resultSetHandl.handle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
