package com.rookie.stack.mybatis.app;

import com.rookie.stack.mybatis.entity.Major;
import com.rookie.stack.mybatis.mapper.MajorAnnotationMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class AnnotationMapperApplication {
    public static void main(String[] args) throws Exception {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        MajorAnnotationMapper majorAnnotationMapper = sqlSession.getMapper(MajorAnnotationMapper.class);
        List<Major> majorList = majorAnnotationMapper.findAll();
        majorList.forEach(System.out::println);

        Major major = majorAnnotationMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println(major);
    }
}
