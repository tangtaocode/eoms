package eoms.cn.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.pagehelper.PageHelper;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages= {"eoms.cn.repository.mapper"})
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(PageHelper pageHelper) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/*.xml"));
        Interceptor[] interceptors = {pageHelper};
        sqlSessionFactoryBean.setPlugins(interceptors);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql"); // 配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
