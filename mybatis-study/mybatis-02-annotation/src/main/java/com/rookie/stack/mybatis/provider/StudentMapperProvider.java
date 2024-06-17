package com.rookie.stack.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class StudentMapperProvider {
    public String findAll() {
        SQL sql = new SQL();
        sql.SELECT("*").FROM("xpu_student");
        return sql.toString();
    }
}
