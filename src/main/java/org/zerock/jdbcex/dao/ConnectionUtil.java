package org.zerock.jdbcex.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {
    INSTANCE;
    private HikariDataSource ds;
    ConnectionUtil() {//기본 private
        HikariConfig config = new HikariConfig();//연결설정 선언
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        //케시 사용
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        //케시의 크기 설정
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        //sql 리미트 크기설정

        ds = new HikariDataSource(config);
    }
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
