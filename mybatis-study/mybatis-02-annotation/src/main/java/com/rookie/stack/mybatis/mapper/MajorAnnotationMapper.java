package com.rookie.stack.mybatis.mapper;

import com.rookie.stack.mybatis.entity.Major;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public interface MajorAnnotationMapper {
    @Select("select * from xpu_major")
    List<Major> findAll();

    @Select("select * from xpu_major where id = #{id}")
    Major findById(String id);
}
