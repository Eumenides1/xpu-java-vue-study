package com.rookie.stack.xpu.test;

import com.rookie.stack.xpu.dao.UserDao;
import com.rookie.stack.xpu.domain.entity.Users;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@SpringBootTest
public class UserTest {

    @Resource
    private UserDao userDao;
    @Test
    public void getUserByPhoneTest(){
        Users userByPhone = userDao.getUserByPhone("15129393333");
        System.out.println(userByPhone);
    }


}
