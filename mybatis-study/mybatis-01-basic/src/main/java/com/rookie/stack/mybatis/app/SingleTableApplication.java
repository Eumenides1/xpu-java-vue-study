package com.rookie.stack.mybatis.app;

import com.rookie.stack.mybatis.dao.MajorDao;
import com.rookie.stack.mybatis.entity.Major;
import com.rookie.stack.mybatis.service.MajorDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class SingleTableApplication {
    public static void main(String[] args) throws Exception {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);

        MajorDao majorDao = new MajorDaoImpl(sqlSessionFactory);
        List<Major> majorList = majorDao.findAll();
        majorList.forEach(System.out::println);
    }
}
