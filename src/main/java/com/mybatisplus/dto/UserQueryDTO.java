package com.mybatisplus.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserQueryDTO {
    String name;
    Integer status;
    Integer minBalance;
    Integer maxBalance;
}
