package com.rookie.stack.mybatis.service;

import com.rookie.stack.mybatis.dao.MajorDao;
import com.rookie.stack.mybatis.entity.Major;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class MajorDaoImpl implements MajorDao {

    private SqlSessionFactory sqlSessionFactory;

    public MajorDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Major> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("majorMapper.findAll");
        }
    }

    @Override
    public Major findById(String id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("majorMapper.findById", id);
        }
    }
}
