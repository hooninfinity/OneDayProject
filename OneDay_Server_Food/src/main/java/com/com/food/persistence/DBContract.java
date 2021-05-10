package com.com.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
private static Connection dbConn = null;
	
	// static 으로 선언된 dbConn 객체를 초기화하는 코드
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";
		
		try {
			// Java 1.7 이상에서는 사용하지 않아도 되는 코드
			Class.forName(jdbcDriver);
			
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 OK!!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 Driver를 찾을 수 없음");
			System.out.println("오라클 Ojdbc6.jar 를 확인하세요");
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("오라클 DBMS 연결 실패!!");
			System.out.println("접속 정보를 확인하세요!!");
			System.out.println("-".repeat(30));
			System.out.println("URL : " + url);
			System.out.println("User : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	} // end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}
