package com.ecidi.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccoutController {

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url")String url){
        return url;
    }

}
