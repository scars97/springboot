package hrd_02;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static Connection getConnection() throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pw = "oracle";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,id,pw);
		
		return conn;
	}
}
