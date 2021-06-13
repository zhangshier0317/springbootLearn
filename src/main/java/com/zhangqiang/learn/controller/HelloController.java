package com.zhangqiang.learn.controller;

import com.zhangqiang.learn.bean.Car;
import com.zhangqiang.learn.dao.QueryDb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;
    @Autowired
    QueryDb queryDb;

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        log.info("日志哈哈好好");
        queryDb.testJdbc();
        return "hello你好"+name ;
    }
    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }


}
