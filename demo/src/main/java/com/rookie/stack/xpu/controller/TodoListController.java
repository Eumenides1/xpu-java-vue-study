package com.rookie.stack.xpu.controller;
import com.rookie.stack.xpu.service.ITodoListService;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jaguarliu
 * @since 2024-06-17
 */
@RestController
@RequestMapping("/todoList")
public class TodoListController {
    @Resource
    private ITodoListService todoListService;

    @GetMapping("/getItemName")
    public String getItems(){
        return todoListService.getAllItem().get(0).getItemId();
    }

}

