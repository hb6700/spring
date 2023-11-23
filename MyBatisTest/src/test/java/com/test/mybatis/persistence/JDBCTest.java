package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	@Test
	public void testConnection() {
		//JDBC 연결 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "java1234");
			assertNotNull(conn);
			
			log.info(conn.isClosed());
			//log.warn("warning");
			//log.error("error");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
