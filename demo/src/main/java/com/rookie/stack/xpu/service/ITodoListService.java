package com.rookie.stack.xpu.service;

import com.rookie.stack.xpu.domain.entity.TodoList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaguarliu
 * @since 2024-06-17
 */
public interface ITodoListService {

    List<TodoList> getAllItem();

}
