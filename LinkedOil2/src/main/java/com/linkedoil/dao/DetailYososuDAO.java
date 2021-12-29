package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.DetailYososuVO;
import com.linkedoil.vo.YososuVO;

public class DetailYososuDAO {

	
	public DetailYososuVO detailYososu(String name) {
		DetailYososuVO dy = null;
		String sql = "select * from yososu where name=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dy = new DetailYososuVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getDouble(8));

			}

			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}

		return dy;
	}
	 
	 
}
