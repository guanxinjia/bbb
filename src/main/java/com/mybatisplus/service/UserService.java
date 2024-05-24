package com.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatisplus.dto.UserQueryDTO;
import com.mybatisplus.po.User;

import java.util.List;


public interface UserService extends IService<User> {
    List<User> queryUsers(UserQueryDTO queryDTO);
    void deductBalance(Integer drawnMoney,Integer id);
}
