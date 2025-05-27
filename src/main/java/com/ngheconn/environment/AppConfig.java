package com.ngheconn.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
     HikariDataSourceFactory hikariDataSourceFactory() {
        return new HikariDataSourceFactoryImpl();
    }
}
