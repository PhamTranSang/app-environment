package com.ngheconn.environment;

import com.zaxxer.hikari.HikariDataSource;

public interface HikariDataSourceFactory {

    /**
     * Create a DataSource with the given properties and poolName.
     * */
    HikariDataSource createHikariDataSource(final String username, final String password, final String url, final String driverClassName);
}
