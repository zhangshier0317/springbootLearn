package com.zhangqiang.learn.mapper;

import com.zhangqiang.learn.bean.Zq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface TestMapper {
    public Zq getZq(int id);

    public List<Zq> getAllZq();

    public int addZq(Zq zq);

    public int updateZq(int id,String name);

    public int deleteZq(int id);
}
