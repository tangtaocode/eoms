 package eoms.cn.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

import eoms.cn.commons.annotation.DataSourceAnnotation;

@Configuration
 public class DataSourceConfig {
    
    @Autowired
    private Environment env;
    
    public DataSource defaultDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.datasource.url"));
        datasource.setUsername(env.getProperty("spring.datasource.username"));
        datasource.setPassword(env.getProperty("spring.datasource.password"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        datasource.setInitialSize(4);
        datasource.setMinIdle(8);
        datasource.setMaxActive(8);
        datasource.setMaxWait(60000);
        return datasource;
    }
    
    public DataSource chrDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.datasource.ehr.url"));
        datasource.setUsername(env.getProperty("spring.datasource.ehr.username"));
        datasource.setPassword(env.getProperty("spring.datasource.ehr.password"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.ehr.driver-class-name"));
        datasource.setInitialSize(4);
        datasource.setMinIdle(8);
        datasource.setMaxActive(8);
        datasource.setMaxWait(60000);
        return datasource;
    }
    
    @Primary
    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put(DataSourceAnnotation.DEFAULT_DATASOURCE, defaultDataSource());
        dsMap.put(DataSourceAnnotation.CHR_DATASOURCE, chrDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

}
