package com.zhangqiang.learn.bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhangqiang.learn.util.EncryptionAndDecrypt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 数据库密码解密
 */
public class DruidDataSourceH extends DruidDataSource {
    @Override
    public String getPassword() {
        return EncryptionAndDecrypt.decode(super.getPassword());
    }
}
