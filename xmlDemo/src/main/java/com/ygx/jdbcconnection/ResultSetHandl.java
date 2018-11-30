package com.ygx.jdbcconnection;

import java.sql.ResultSet;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/149:09
 * @Version: 1.0
 */
public interface ResultSetHandl<T> {
    T handle(ResultSet resultSet);
}
