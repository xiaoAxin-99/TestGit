package com.xinrong.demo.config;

import com.xinrong.demo.constant.AceBaoBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/10 1:51 下午
 */
@Configuration
@MapperScan(basePackages = "",sqlSessionFactoryRef =AceBaoBean.ENTRY_FACTORY)
public class EntryDataSourceConfig {
    @Bean(name = AceBaoBean.ENTRY_FACTORY)
    public SqlSessionFactory h2018EntrySqlSessionFactory(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
            @Qualifier(AceBaoBean.ENTRY_DATASOURCE)DataSource dataSource)
            throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/"));
        return bean.getObject();
    }

    @Bean(name = AceBaoBean.ENTRY_TEMPLATE)
    public SqlSessionTemplate h2018sqlSessionTemplate(
            @Qualifier(AceBaoBean.ENTRY_FACTORY) SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}


