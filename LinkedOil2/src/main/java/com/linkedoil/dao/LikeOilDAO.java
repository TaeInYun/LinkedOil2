package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.LikeOilVO;

public class LikeOilDAO {
	
	public static int insertLikeOil(LikeOilVO vo) {
		int re = -1;
		String sql = "insert into like_oil values( "
				+ "(select nvl(max(like_oil_no),0)+1 from like_oil), "
				+ " ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
			try {
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getNo());
				pstmt.setString(2, vo.getOil_code());
				re = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("예외발생: " + e.getMessage());
			}finally {
				ConnectionProvider.close(conn, pstmt);
			}
		
		return re;
	}
}
