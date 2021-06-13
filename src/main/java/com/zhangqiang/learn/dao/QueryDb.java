package com.zhangqiang.learn.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueryDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void testJdbc(){
        Long o = jdbcTemplate.queryForObject("select count(*) from zq_test",Long.class);
        log.info("查询结果"+o);
    }
}
