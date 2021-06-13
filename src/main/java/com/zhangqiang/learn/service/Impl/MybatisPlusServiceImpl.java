package com.zhangqiang.learn.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangqiang.learn.bean.Zq;
import com.zhangqiang.learn.mapper.MyBatisPlusMapper;
import com.zhangqiang.learn.service.MyBatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusServiceImpl extends ServiceImpl<MyBatisPlusMapper,Zq> implements MyBatisPlusService {

}
