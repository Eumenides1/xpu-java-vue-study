package com.rookie.stack.mybatis.dao;

import com.rookie.stack.mybatis.entity.Major;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public interface MajorDao {

    List<Major> findAll();

    Major findById(String id);
}
