package com.example.webserver.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class WebDBConfig {

    @Bean(name = "webDBDataSource")
    @ConfigurationProperties(prefix = "spring.webdb.datasource")
    public DataSource webDBDataSource() { return DataSourceBuilder.create().build(); }

    @Bean(name = "webDBSqlSessionFactory")
    public SqlSessionFactory webDBSqlSessionFactory(@Qualifier("webDBDataSource") DataSource webDBDataSource,
                                                    ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(webDBDataSource);
        sqlSessionFactoryBean.setMapperLocations(
            applicationContext.getResources("classpath:mapper/webdb/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "webDBSqlSessionTemplate")
    public SqlSessionTemplate webDBSqlSessionTemplate(@Qualifier("webDBSqlSessionFactory") SqlSessionFactory webDBSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(webDBSqlSessionFactory);
    }

    @Bean(name = "webDBTxManager")
    public DataSourceTransactionManager webDBTransactionManager(@Qualifier("webDBDataSource") DataSource webDBDataSource) {
        return new DataSourceTransactionManager(webDBDataSource);
    }
}
