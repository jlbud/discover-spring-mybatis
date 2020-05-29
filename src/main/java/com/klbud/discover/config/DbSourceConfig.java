package com.klbud.discover.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = DbSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DbSourceConfig {

    static final String PACKAGE = "com.klbud.discover.dao";
    private static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "dspStaffPool00")
    @ConfigurationProperties(prefix = "dsp.staff.pool00.datasource")
    public DataSource pool00DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dspStaffPool01")
    @ConfigurationProperties(prefix = "dsp.staff.pool01.datasource")
    public DataSource pool01DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dspPool")
    @ConfigurationProperties(prefix = "dsp.pool.datasource")
    public DataSource dspPoolDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<Object, Object> dbMap = new HashMap<>();
        dbMap.put("00", pool00DataSource()); // 数据源1
        dbMap.put("01", pool01DataSource()); // 数据源2

        dynamicDataSource.setTargetDataSources(dbMap);

        dynamicDataSource.setDefaultTargetDataSource(pool00DataSource());
        return dynamicDataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory()
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dynamicDataSource());
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DbSourceConfig.MAPPER_LOCATION));
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
