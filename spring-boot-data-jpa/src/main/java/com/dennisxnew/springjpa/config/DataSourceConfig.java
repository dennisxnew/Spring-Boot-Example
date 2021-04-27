package com.dennisxnew.springjpa.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Dennis.Chen
 * @Date 20210426
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource) {
        Properties properties = new Properties();

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.id.new_generator_mappings", false);
        properties.put("hibernate.show_sql", true);
        try {
            //若有SQL想放在XML管理，可透過以下設定讀取
            //Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:hibernate-config/*.hbm.xml");
            //factory.setMappingLocations(resources);
            factory.setPackagesToScan(new String[] {"com.dennisxnew.springjpa.model"});
            factory.setHibernateProperties(properties);
            factory.setDataSource(dataSource);
            factory.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SessionFactory sessionFactory = factory.getObject();
        return sessionFactory;
    }

    @Primary
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }

    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }

}
