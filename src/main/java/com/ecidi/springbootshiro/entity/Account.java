package com.ecidi.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("account")
public class Account {
    @TableId(type = IdType.ASSIGN_UUID)
    private String guid;
    private String username;
    private String password;
    private String perms;
    private String role;
}
