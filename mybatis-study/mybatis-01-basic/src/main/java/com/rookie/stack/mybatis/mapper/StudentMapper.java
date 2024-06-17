package com.rookie.stack.mybatis.mapper;

import com.rookie.stack.mybatis.entity.Student;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public interface StudentMapper {
    List<Student> findAll();
}
