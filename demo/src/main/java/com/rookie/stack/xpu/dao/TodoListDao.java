package com.rookie.stack.xpu.dao;

import com.rookie.stack.xpu.domain.entity.TodoList;
import com.rookie.stack.xpu.mapper.TodoListMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jaguarliu
 * @since 2024-06-17
 */
@Service
public class TodoListDao extends ServiceImpl<TodoListMapper, TodoList>  {
    @Resource
    private  TodoListMapper todoListMapper;

    public List<TodoList> getAllItem(){
        // select * from todo_list;
        return lambdaQuery().list();
    }

}
