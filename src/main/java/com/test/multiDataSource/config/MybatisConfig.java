package com.test.multiDataSource.config;

import com.test.multiDataSource.enums.DataSourceType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by guanguan on 2017/7/20.
 */
@Configuration
@MapperScan("com.test.multiDataSource.dao")  //扫描到dao层实现mybatis的xml文件与dao层的文件进行映射绑定
public class MybatisConfig {



    /**
     * 创建数据源 manage
     * @return
     * @throws Exception
     */
    @Bean
    @ConfigurationProperties(prefix = "manage")
    public DataSource manageDataSource() throws Exception{
        return DataSourceBuilder.create().build();
    }


    /**
     * 创建数据源 test
     * @return
     * @throws Exception
     */
    @Bean
    @ConfigurationProperties(prefix = "test")
    public DataSource testDataSource() throws Exception{

        return DataSourceBuilder.create().build();
    }


    /**
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("manageDataSource") DataSource manageDataSource,
                                        @Qualifier("testDataSource") DataSource testDataSource){
        HashMap<Object,Object> targetDataSources = new HashMap<Object,Object>();
        targetDataSources.put(DataSourceType.manage,manageDataSource);
        targetDataSources.put(DataSourceType.test,testDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources); //该方法是继承的AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(manageDataSource); //设置默认的数据源

        return dataSource;
    }




    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


}
