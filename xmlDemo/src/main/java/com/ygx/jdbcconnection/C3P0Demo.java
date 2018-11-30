package com.ygx.jdbcconnection;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/13 9:28
 * @Version: 1.0
 */
public class C3P0Demo {

    /**
     * 1.c3p0 通过代码形式配置数据库驱动，账户，密码
     **/
    @Test
    public void C3P0Test01() {
        // 1.获取数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            // 2.设置驱动，账户，密码
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/springmvc04");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("123456");

            // 3.获取数据库连接
            Connection connection = comboPooledDataSource.getConnection();

            String sql = "insert into user values (null ,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"爱新觉罗·玄烨");
            preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
            preparedStatement.setString(3,"男");
            preparedStatement.setString(4,"北京市东城区故宫");

           int i = preparedStatement.executeUpdate();
            System.out.println("存储成功："+i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.c3p0 通过读取配置文件的形式读取数据库驱动，账户，密码
     **/
    @Test
    public void C3P0Test02() {

        // 1.获取数据源对象，并自动读取配置文件，配置文件名字默认：c3p0-config.xml
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            // 3.获取数据库连接
            Connection connection = comboPooledDataSource.getConnection();

            String sql = "insert into user values (null ,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"爱新觉罗·胤禛");
            preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
            preparedStatement.setString(3,"男");
            preparedStatement.setString(4,"北京市东城区故宫");

            int i = preparedStatement.executeUpdate();
            System.out.println("存储成功："+i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
