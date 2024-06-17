package com.rookie.stack.mybatis.mapper;

import com.rookie.stack.mybatis.entity.Major;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public interface MajorMapper {

    List<Major> findAll();

    int insert(Major major);

    int update(Major major);

    int deleteById(String id);

    Major findById(String id);
}
