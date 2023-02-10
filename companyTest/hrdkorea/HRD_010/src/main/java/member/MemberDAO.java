package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {//DB 데이터 가져오기
	
	//1.회원등록 
	public int join(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null; 
		
		try {
			conn = DatabaseConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, custno);
			pstmt.setString(2, custname);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, joindate);
			pstmt.setString(6, grade);
			pstmt.setString(7, city);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
