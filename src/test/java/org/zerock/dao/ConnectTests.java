package org.zerock.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {
    private static final Logger log = LoggerFactory.getLogger(ConnectTests.class);

    @Test
    public void test1() {
        int v1=10;
        int v2=10;
        Assertions.assertEquals(v1,v2);

    }
    @Test
    public void test2() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn =
                DriverManager.getConnection("jdbc:mariadb://localhost:3306/webdb","webuser","webuser");
        Assertions.assertNotNull(conn);
        conn.close();
    }
    @Test
    public void test3() throws Exception {//다중연결
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

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+conn);
        Assertions.assertNotNull(conn);
        conn.close();
    }
}
