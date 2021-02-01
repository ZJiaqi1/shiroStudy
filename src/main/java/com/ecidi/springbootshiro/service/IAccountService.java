package com.ecidi.springbootshiro.service;

import com.ecidi.springbootshiro.entity.Account;

public interface IAccountService {
    public Account findByUsername(String username);
}
