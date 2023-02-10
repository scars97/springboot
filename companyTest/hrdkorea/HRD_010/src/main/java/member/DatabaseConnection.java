package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {//DB 연결 클래스
			
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";//오라클 사용
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//ip,host 연결
		String userid = "system";
		String password = "oracle";
		
		//드라이버 검색 (db와 연동 준비)
		try {
			Class.forName(driver);
			System.out.println("드라이버 검색 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패");
			System.exit(0);
		}
		
		//데이터베이스 연결 - 커넥션 만들기 
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userid,password);
			System.out.println("데이터베이스 연결 성공");
			
			return conn;
		} catch (SQLException e) {
			System.err.println("데이터베이스 연결 실패");
			System.exit(0);
		} 
		return null;
	}
}
	
//	public static Connection getConnection() {
//
//		String driver = "oracle.jdbc.driver.OracleDriver";//오라클 사용
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";//ip,host 연결
//		String userid = "system";
//		String password = "oracle"; //시험에서는 1234
//		
//		try {
//			Class.forName(driver);
//			Connection conn = DriverManager.getConnection(url, userid, password);
//			
//			return conn;
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("driver 연결 실패 - 오타있는지 확인해");
//			e.printStackTrace();
//		
//		} catch (SQLException e) {
//			System.out.println("DB 연결 실패 - 입력한 정보 틀림");
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

