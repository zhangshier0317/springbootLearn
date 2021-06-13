package com.zhangqiang.learn.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
//@TableName("zq_test")//实体类真正对应的表名
public class Zq {
    //@TableField(exist = false)//表示该字段在数据库不存在
    public int id;
    public String name;
    public String gender;
    public User user;
    public List<Pet> pets;
}
