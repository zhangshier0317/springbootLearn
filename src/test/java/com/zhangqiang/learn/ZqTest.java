package com.zhangqiang.learn;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZqTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void testJdbc(){
        Long o = jdbcTemplate.queryForObject("select count(*) from zq_test",Long.class);
        log.info(String.valueOf(o));
        log.info("当前数据源是"+dataSource.getClass());
    }

    @Test
    public void testRedis(){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("cp","常盼盼");
        String str = valueOperations.get("cp");
        System.out.println(str);
    }
}
