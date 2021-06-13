package com.zhangqiang.learn.service;

import com.zhangqiang.learn.bean.Zq;
import com.zhangqiang.learn.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZqService {

    @Autowired
    TestMapper testMapper;

    public Zq getZqById(int id){
        return testMapper.getZq(id);
    }

    public List<Zq> getAllZq(){
        return testMapper.getAllZq();
    }

    public int addZq(Zq zq){
        return testMapper.addZq(zq);
    }

    public int updateZq(int id,String name){
        return testMapper.updateZq(id,name);
    }

    public int deleteZq(int id){
        return testMapper.deleteZq(id);
    }
}
