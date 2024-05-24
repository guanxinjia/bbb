package com.mybatisplus.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
//test
@Data
public class TestDTO {
    @TableId(type = IdType.AUTO)
    Integer id;

    String name;
}
