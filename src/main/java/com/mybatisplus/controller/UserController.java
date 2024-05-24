package com.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.mybatisplus.dto.UserQueryDTO;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.po.User;
import com.mybatisplus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserMapper userMapper;
    private final UserService service;
    @Operation(summary = "复杂条件查询")
    @GetMapping("/query")
    public List<User> queryUsers(UserQueryDTO queryDTO){

       List<User>  list =  service.queryUsers(queryDTO);
       return list;
    }
    @Operation(summary = "更新测试,点一下即可")
    @PostMapping("/update")
    public void updateTest(){
        LambdaUpdateChainWrapper<User> wrapper = new LambdaUpdateChainWrapper<User>(userMapper);
        wrapper.set(User::getUsername,"sparkhope")
                .eq(User::getUsername,"Hope")
                .update();
    }
}
