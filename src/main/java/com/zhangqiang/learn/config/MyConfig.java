package com.zhangqiang.learn.config;

import ch.qos.logback.core.db.DBHelper;
import com.zhangqiang.learn.bean.Car;
import com.zhangqiang.learn.bean.Pet;
import com.zhangqiang.learn.bean.User;
import com.zhangqiang.learn.interceptor.RedisAccountUrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * proxyBeanMethods:代理bean的方法
 * proxyBeanMethods = true 外部无论对配置类中的组件注册方法调用多少次，获取的都是之前注册到容器中的单实例（springboot总会
 * 检查这个组件在容器中是否存在，如果没有就创建，有就取，要保持容器单实例）
 * proxyBeanMethods = false 外部每次调用获取的都是一个新对象，好处是springboot会跳过检查容器中是否有对象的操作
 * 启动速度变快，没有组件依赖都使用false
 *
 * @Import({User.class, DBHelper.class})让容器自动创建这两个类型的组件,默认组件的名字就是全类名
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) //告诉SpringBoot这是一个配置类
@EnableConfigurationProperties(Car.class)//开启Car的配置绑定功能，把Car组件自动注入到容器中
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    RedisAccountUrlInterceptor redisAccountUrlInterceptor;

    @ConditionalOnMissingBean(name="pet")//容器中有pet组件时才会创建getUser
    @Bean//给容器中添加组件，以方法名作为组件ID，返回类型是组件类型，返回值就是组件在容器中的实例
    public User getUser(){
        return new User("测试人",18);
    }

    //@Bean("pet")
    public Pet getPet(){
        return new Pet("测试宠物",8);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(redisAccountUrlInterceptor).addPathPatterns("/**");
    }
}
