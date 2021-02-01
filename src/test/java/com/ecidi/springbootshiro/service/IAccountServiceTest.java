package com.ecidi.springbootshiro.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IAccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    void findByUsername() {
        System.out.println(accountService.findByUsername("张三"));

    }
}