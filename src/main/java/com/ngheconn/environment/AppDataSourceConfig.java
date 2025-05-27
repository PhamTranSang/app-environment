package com.ngheconn.environment;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class AppDataSourceConfig {

    /**
     * Retrieve the properties for the app datasource.
     * */
    @Bean
    @ConfigurationProperties("app.datasource")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Build the app datasource.
     * */
    @Bean(DataSourceConstants.APP_DATASOURCE)
    @ConfigurationProperties("app.datasource.configuration")
    HikariDataSource appDataSource(final HikariDataSourceFactory hikariDataSourceFactory) {
        return hikariDataSourceFactory.createHikariDataSource(
                dataSourceProperties().getUsername(),
                dataSourceProperties().getPassword(),
                dataSourceProperties().getUrl(),
                dataSourceProperties().getDriverClassName()
        );
    }

    /**
     * Initialize the app EntityManager factory.
     * */
    @Bean(DataSourceConstants.ENTITY_MANAGER_FACTORY)
    LocalContainerEntityManagerFactoryBean appEntityManagerFactory(//
            final EntityManagerFactoryBuilder builder, //
            @Qualifier(DataSourceConstants.APP_DATASOURCE) final DataSource dataSource //
    ) {
        return builder.dataSource(dataSource)
                .packages("com.ngheconn.environment")
                .persistenceUnit(DataSourceConstants.APP_DATASOURCE).build();
    }
}
