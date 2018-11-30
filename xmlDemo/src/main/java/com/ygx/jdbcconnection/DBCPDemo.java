package com.ygx.jdbcconnection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/12 17:13
 * @Version: 1.0
 */
public class DBCPDemo {

    /**
     * 通过实例配置数据库
     **/
    @Test
    public void testDBCP01() {
        // 1.实例化数据源对象
        BasicDataSource basicDataSource = new BasicDataSource();
        try {
            // 2.设置驱动，数据库地址，账户密码
            basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            basicDataSource.setUrl("jdbc:mysql://localhost/springmvc04");
            basicDataSource.setUsername("root");
            basicDataSource.setPassword("123456");

            // 获取连接实例

            Connection connection = basicDataSource.getConnection();
            String sql = "insert into user values (null,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "姚明");
            ps.setDate(2, new Date(System.currentTimeMillis()));
            ps.setString(3, "男");
            ps.setString(4, "上海市");
            ps.executeUpdate();

            System.out.println("存储成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过实例配置数据库
     **/
    @Test
    public void testDBCPByXML() {
        try {
            BasicDataSourceFactory factory = new BasicDataSourceFactory();

            InputStream inputStream =   DBCPDemo.class.getResourceAsStream("/dbcpconfig.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
            try {
                // 创建数据源实例
                DataSource dataSource = factory.createDataSource(properties);
                // 获取数据连接
                Connection connection = dataSource.getConnection();
                // 创建 Statement 对象,用于执行SQL语句
                Statement statement = connection.createStatement();

                String sql = "select * from user";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String name = resultSet.getString("username");
                    String address = resultSet.getString("address");
                    System.out.println("姓名："+name +"  地址："+address);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
