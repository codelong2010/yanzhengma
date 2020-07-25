package com.yanzhengma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaolong
 * @create 2020-07-24 22:22
 * @description
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public Object Index(){
        return "index";
    }
}
