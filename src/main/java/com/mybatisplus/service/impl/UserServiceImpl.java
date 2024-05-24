package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.dto.UserQueryDTO;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.po.User;
import com.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired(required = false)
    UserMapper mapper;


    @Override
    public List<User> queryUsers(UserQueryDTO queryDTO) {
        String name = queryDTO.getName();
        Integer status = queryDTO.getStatus();
        Integer maxBalance = queryDTO.getMaxBalance();
        Integer minBalance = queryDTO.getMinBalance();

        return  new LambdaQueryChainWrapper<User>(mapper)
                .like(name!=null,User::getUsername,name)
                .eq(status!=null,User::getStatus,status)
                .ge(minBalance!=null,User::getBalance,minBalance)
                .le(maxBalance!=null,User::getBalance,maxBalance)
                .list();
    }

    @Override
    public void deductBalance(Integer drawnMoney, Integer id) {
        User user = mapper.selectById(id);
        Integer balance = user.getBalance();
        log.info("user:{}",user);
        log.info("balance:{}",balance);
        if(user==null||balance<0||user.getStatus()==2){
            throw new RuntimeException("用户状态异常");
        }
        Integer remainBalance = (Integer) drawnMoney;
       new LambdaUpdateChainWrapper<User>(mapper)
               .set(User::getBalance,remainBalance)
               .set(remainBalance==0,User::getStatus,2)
               .eq(User::getId,id)
               .update();
    }
}
