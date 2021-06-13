package com.zhangqiang;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class World {
    @RequestMapping("/world")
    public String world(){
        return "world你好";
    }
}
