package com.rookie.stack.xpu.service.impl;

import com.rookie.stack.xpu.dao.TodoListDao;
import com.rookie.stack.xpu.domain.entity.TodoList;
import com.rookie.stack.xpu.service.ITodoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
@Service
public class TodoListServiceImpl implements ITodoListService {

    @Resource
    private TodoListDao todoListDao;

    @Override
    public List<TodoList> getAllItem() {
        return todoListDao.getAllItem();
    }
}
