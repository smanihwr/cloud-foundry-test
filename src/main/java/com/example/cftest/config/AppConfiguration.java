package com.example.cftest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.cloud.service.PooledServiceConnectorConfig.PoolConfig;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class AppConfiguration extends AbstractCloudConfig {

    @Bean
    public Cloud cloud() {
        System.out.println(" *********************** inside cloud() *********************** ");
        return new CloudFactory().getCloud();
    }

    @Bean
    public DataSource dataSource() {
        System.out.println(" *********************** inside dataSource() *********************** ");
        PoolConfig poolConfig = new PoolConfig(1, 4, 3000);
        DataSourceConfig.ConnectionConfig connConfig =
                new DataSourceConfig.ConnectionConfig("useUnicode=yes;characterEncoding=UTF-8");
        DataSourceConfig dbConfig = new DataSourceConfig(poolConfig, connConfig);
        return connectionFactory().dataSource("cf-my-sql", dbConfig);
    }
}
