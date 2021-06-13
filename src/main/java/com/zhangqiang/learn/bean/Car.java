package com.zhangqiang.learn.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件才能使用springboot的功能
 */
//@Component
@Data //lombok生成属性的get/set方法
@ToString //lombok生成对象的toString方法
@AllArgsConstructor //lombok生成对象的有参构造器（所有参数）
@NoArgsConstructor //lombok生成对象的无参构造器
@EqualsAndHashCode //用对象中属性重新equals和hashCode方法
@ConfigurationProperties(prefix = "mycar")//ConfigurationProperties注解读取配置文件中前缀为prefix定义的属性
                                        // prefix不能使用驼峰写法
public class Car {
    private String name;
    private String brand;
}
