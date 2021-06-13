package com.zhangqiang.learn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //lombok生成属性的get/set方法
@ToString //lombok生成对象的toString方法
@AllArgsConstructor //lombok生成对象的有参构造器（所有参数）
@NoArgsConstructor //lombok生成对象的无参构造器
public class Pet {
    private String name;
    private int age;
}
