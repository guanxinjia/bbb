package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.po.Address;

/**
* @author lenovo
* @description 针对表【address】的数据库操作Mapper
* @createDate 2024-05-11 12:05:20
* @Entity com.mybatisplus.po.Address
*/
public interface AddressMapper extends BaseMapper<Address> {

    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

}
