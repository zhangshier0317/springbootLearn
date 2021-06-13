package com.zhangqiang.learn.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zhangqiang.learn.bean.DruidDataSourceH;
import com.zhangqiang.learn.util.EncryptionAndDecrypt;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class DruidDataSourceConfig{
    /**
     * 配置Druid数据源
     * @return
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSourceH dataSource = new DruidDataSourceH();
        //System.out.println("数据库密码:"+dataSource.getPassword());
        dataSource.setFilters("stat,wall");//stat,Druid数据源监控页加入监控功能,wall开启sql防注入功能
        return dataSource;
    }
    /**
     * 配置Druid监控页
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","admin");
        return statViewServletServletRegistrationBean;
    }

    /**
     * 开启Druid监控页的web应用和URI监控功能
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }

}
