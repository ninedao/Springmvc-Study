package com.lzc.config;


import ch.qos.logback.classic.Logger;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.config.JtaTransactionManagerFactoryBean;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
//@ComponentScan(basePackages = "com.lzc")
@PropertySource("classpath:properties/jdbc.properties")
@EnableTransactionManagement
//@MapperScan(basePackages="com.lzc.mapper")
public class SpringApplicationConfig {
    //final static Logger logger = LoggerFactory.getLogger(MyApp1.class);
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.filters}")
    private String filters;
    @Value("${jdbc.publicKey}")
    private String publicKey;

    @Bean
    public DataSource mysqlDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setFilters(filters);
        Properties properties = new Properties();
        properties.setProperty("config.decrypt", "true");
        properties.setProperty("config.decrypt.key", publicKey);
        dataSource.setConnectProperties(properties);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource mysqlDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(mysqlDataSource);

        // 配置mapper的扫描，找到所有的mapper.xml映射文件
//        Resource[] resources = new PathMatchingResourcePatternResolver()
//                .getResources("classpath:com/lzc/mapper/*.xml");
//        sessionFactoryBean.setMapperLocations(resources);

        // 加载全局的配置文件
        //sessionFactoryBean.setConfigLocation(
        //        new DefaultResourceLoader().getResource("classpath:mybatis-config.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager classDataSourceTransactionManager(DataSource mysqlDataSource){
        return new DataSourceTransactionManager(mysqlDataSource);
    }
//    如果你正使用一个 JEE 容器而且想让 Spring 参与到容器管理事务（Container managed transactions，CMT）的过程中，
//    那么 Spring 应该被设置为使用 JtaTransactionManager 或由容器指定的一个子类作为事务管理器。
//    最简单的方式是使用 Spring 的事务命名空间或使用 JtaTransactionManagerFactoryBean

}
