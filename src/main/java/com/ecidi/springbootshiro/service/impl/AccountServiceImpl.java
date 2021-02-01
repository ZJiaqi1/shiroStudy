package com.ecidi.springbootshiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecidi.springbootshiro.entity.Account;
import com.ecidi.springbootshiro.mapper.AccountMapper;
import com.ecidi.springbootshiro.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return accountMapper.selectOne(wrapper);
    }
}
