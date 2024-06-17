package com.rookie.stack.mybatis.mapper;

import com.rookie.stack.mybatis.entity.Student;
import com.rookie.stack.mybatis.provider.StudentMapperProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public interface StudentAnnotationMapper {

    @SelectProvider(type = StudentMapperProvider.class, method = "findAll")
    List<Student> findAll();

}
