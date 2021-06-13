package com.zhangqiang.learn.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RedisAccountUrlInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate sRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //每次访问+1
        sRedisTemplate.opsForValue().increment(requestURI);
        return true;
    }
}
