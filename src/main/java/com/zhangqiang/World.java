package com.zhangqiang;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class World {
    @RequestMapping("/world")
    public String world(){
        String hh = "你好哈哈";
        String h2 = "你好哈哈2";
        String h23 = "你好哈哈3";
        String h24 = "你好哈哈3";
        return "world你好";
    }
}
