package com.zhangqiang.learn;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhangqiang.learn.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//scanBasePackages 指定包扫描路径
@MapperScan("com.zhangqiang.learn.mapper")
@SpringBootApplication(scanBasePackages = "com.zhangqiang")
public class Main {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
        //查看组件的名字
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        /*for (String name : beanDefinitionNames) {
            System.out.println(name);
        }*/
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String name:beanNamesForType) {
            System.out.println(name);
        }
        //从容其中获取组件
        /*Object getUser = run.getBean("getUser");
        System.out.println(getUser);*/

        //判断容器中是否有某个组件
        boolean dataSource = run.containsBean("dataSource");
        System.out.println(dataSource);
        DruidDataSource dataSource1 = (DruidDataSource) run.getBean("dataSource");
        System.out.println("数据库密码是:"+dataSource1.getPassword());
    }
}
