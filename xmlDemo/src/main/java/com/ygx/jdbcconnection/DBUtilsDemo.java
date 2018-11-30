package com.ygx.jdbcconnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.util.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/13 14:40
 * @Version: 1.0
 */
public class DBUtilsDemo {

    @Test
    public void DBUtilsTest01(){
        // 1.获取数据源对象，并自动读取配置文件，配置文件名字默认：c3p0-config.xml
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        // DBUtils的
        QueryRunner queryRunner = new QueryRunner(dataSource);
        try {

            // 增加
//            queryRunner.update("insert into user values(null,?,?,?,?)","爱新觉罗·弘历",new Date(System.currentTimeMillis()),"男","北京市长安街1号紫禁城");
            // 修改
//            queryRunner.update("update user set username = ? where id =?","爱新觉罗·福临",1);
            // 删除
//            queryRunner.update("delete from user where id = ?",2);

            // 查找
            queryRunner.query("select * from user", new ResultSetHandler<List<Map<String,Object>>>() {
                @Override
                public List<Map<String, Object>> handle(ResultSet resultSet) throws SQLException {
                    List<Map<String,Object>> userList = new ArrayList<>();
                    while (resultSet.next()){
                      String username = resultSet.getString("username");
                      String birthday = resultSet.getString("birthday");
                      String sex = resultSet.getString("sex");
                      String adress = resultSet.getString("address");
                        System.out.println("姓名："+username+" 出生日期："+birthday+" 性别："+sex+" 地址："+adress);
                    }
                    return null;
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DBUtilsTest02(){
        DBUtils.ExtUpdate("insert into user values(null,?,?,?,?)","爱新觉罗·皇太极",new Date(System.currentTimeMillis()),"男","北京市长安街1号紫禁城");
    }

    @Test
    public void DBUtilsTest03(){
        DBUtils.Query("select * from user", new ResultSetHandl() {
            @Override
            public List<Map<String,Object>> handle(ResultSet resultSet) {
                List<Map<String,Object>>  userList = new ArrayList<>();
                try {
                    while (resultSet.next()){
                        String username = resultSet.getString("username");
                        String birthday = resultSet.getString("birthday");
                        String sex = resultSet.getString("sex");
                        String adress = resultSet.getString("address");
                        System.out.println("姓名："+username+" 出生日期："+birthday+" 性别："+sex+" 地址："+adress);
                        Map map =new HashMap();
                        map.put("username",username);
                        map.put("adress",adress);
                        userList.add(map);
                    }

                    return userList;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }



}
