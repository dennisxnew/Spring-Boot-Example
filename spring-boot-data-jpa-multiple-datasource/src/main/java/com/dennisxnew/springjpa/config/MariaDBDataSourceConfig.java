package com.dennisxnew.springjpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.dennisxnew.springjpa.dao.mariadb.repo",
        entityManagerFactoryRef = "mariaDBEntityManagerFactoryBean",
        transactionManagerRef = "mariaDBPlatformTransactionManager"
)
public class MariaDBDataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource.mariadb")
    public DataSource mariaDBDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mariaDBEntityManagerFactoryBean(@Qualifier("mariaDBDataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan(new String[]{"com.dennisxnew.springjpa.model.mariadb"});

        //調查一下這個用途是啥??
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.put("show-sql", true);
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }

    @Bean
    public PlatformTransactionManager mariaDBPlatformTransactionManager(@Qualifier("mariaDBEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean entityManager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());

        return transactionManager;
    }

    @Bean
    public JdbcTemplate mariaDBJdbcTemplate(@Qualifier("mariaDBDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
