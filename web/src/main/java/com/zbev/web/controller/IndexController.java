package com.zbev.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xlm on  2019/5/24
 */
@Controller
public class IndexController {

    @ResponseBody
    @GetMapping("/")
    public String index(){
       return "spring boot";
    }
}
