package com.sunseaiot.rbac.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description : mysql数据源与mybatis配置
 * @author: liuchuang
 * @date: 2018/5/29 下午2:21
 * @modified by:
 */
@Configuration
@MapperScan(basePackages = "com.sunseaiot.rbac.mapper",sqlSessionTemplateRef  = "sqlSessionTemplate")
public class DatasourceConfig {
    @Autowired
    private Environment env;

    /**
     * 主数据源
     * @return
     * @throws Exception
     */
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource dataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.primary.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.primary.url"));
        props.put("username", env.getProperty("spring.datasource.primary.username"));
        props.put("password", env.getProperty("spring.datasource.primary.password"));
        props.put("validationQuery", env.getProperty("spring.datasource.primary.validationQuery"));
        //指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除.
        props.put("testWhileIdle", env.getProperty("spring.datasource.primary.testWhileIdle"));
        //指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个.
        props.put("testOnBorrow", env.getProperty("spring.datasource.primary.testOnBorrow"));
        //指明是否在归还到池中前进行检验
        props.put("testOnReturn", env.getProperty("spring.datasource.primary.testOnReturn"));
        //空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位. 如果设置为非正数,则不运行空闲连接回收器线程
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("spring.datasource.primary.timeBetweenEvictionRunsMillis"));
        //连接在池中保持空闲而不被空闲连接回收器线程(如果有)回收的最小时间值，单位毫秒. 设置7小时
        props.put("minEvictableIdleTimeMillis", 25200000);
        //maxActive: 最大活动连接: 连接池在同一时间能够分配的最大活动连接的数量,如果设置为非正数则表示不限制
        props.put("maxActive", 100);
        return BasicDataSourceFactory.createDataSource(props);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(), ExecutorType.BATCH);
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
