package com.ngheconn.environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceFactoryImpl implements HikariDataSourceFactory {

    /**
     * {@inheritDoc}
     * */
    @Override
    public HikariDataSource createHikariDataSource(final String username, final String password, final String url, final String driverClassName) {
        // missing mechanism encrypt/decrypt password, implement it later.
        final var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        if (driverClassName != null) {
            hikariConfig.setDriverClassName(driverClassName);
        }
        hikariConfig.setRegisterMbeans(true);
        return new HikariDataSource(hikariConfig);
    }
}
