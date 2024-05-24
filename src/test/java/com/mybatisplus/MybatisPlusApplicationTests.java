package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mybatisplus.mapper.AddressMapper;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.po.Address;
import com.mybatisplus.po.User;

import com.mybatisplus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    UserService service;
    @Autowired(required = false)
    UserMapper userMapper;

    @Test
    void contextLoads() {

    }

}
