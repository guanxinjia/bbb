package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.po.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> query(String name);
}
