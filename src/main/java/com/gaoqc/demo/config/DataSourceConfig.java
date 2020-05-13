package com.gaoqc.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.gaoqc.demo",sqlSessionFactoryRef = "dataSqlSessionFactory")
public class DataSourceConfig {
    @Bean(name = "dataSrouce")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource  dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "dataSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryl(@Qualifier("dataSrouce") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean =new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/UserMapper.xml"));
        return bean.getObject();
    }
    @Bean(name="transactionManager")
    public DataSourceTransactionManager  transactionManager(@Qualifier("dataSrouce") DataSource  dataSource){
    return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
