package com.lihuia.flyaway.testing.mysql.config;

import com.lihuia.flyaway.testing.mysql.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author lihuia.com
 * @date 2022/6/21 12:24 PM
 */

@Configuration
@MapperScan(basePackages = "com.lihuia.flyaway.testing.mysql.mapper")
@PropertySource(value = {"classpath:config/application.properties"})
public class DataSourceConfig {

    @Value("${spring.datasource.druid.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.druid.url}")
    private String url;
    @Value("${spring.datasource.druid.username}")
    private String username;
    @Value("${spring.datasource.druid.password}")
    private String password;
    @Value("${mybatis.type-aliases-package}")
    private String aliasesPackage;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setTypeAliasesPackage(aliasesPackage);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return factoryBean.getObject();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public MapperFactoryBean<UserMapper> userMapper() throws Exception {
        MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }
}
