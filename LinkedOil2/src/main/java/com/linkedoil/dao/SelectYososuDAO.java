package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.YososuVO;

public class SelectYososuDAO {
	public static int pageSize = 10;  
	public static int totalRecord; 
	public static int totalPage;  
	
	public int getTotalRecord(String sido1, String gugun1) {
		int n= 0 ;
		String sql ="select count(*) from yososu ";		
		
		if(sido1 != null && gugun1 != null) {
			sql += "  where addr like '%"+sido1+"%'  and addr like '%"+gugun1+"%'    ";
		} 
		  
		
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					n = rs.getInt(1);
				}
				ConnectionProvider.close(conn, pstmt,rs);
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}	
			return n;
			
		}


	public ArrayList<YososuVO> listyososu(int pageNUM,String sido1, String gugun1){
		
				totalRecord =  getTotalRecord(sido1, gugun1);
				totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
				System.out.println("전체 레코드 :"+totalRecord);
				System.out.println("전체 페이지"+totalPage);
				
				int start =(pageNUM-1)*SelectYososuDAO.pageSize+1;
				int end = start +SelectYososuDAO.pageSize-1;
				
				System.out.println("start"+start);
				System.out.println("end"+end);
				
				
				ArrayList<YososuVO> list = new ArrayList<YososuVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql2 = "select * from yososu";
			
			
			if(sido1 != null && gugun1 != null) {
				sql2 += "  where  addr like '%"+sido1+"%'  and addr like '%"+gugun1+"%'    ";
			}
			 
			String sql = "select name ,addr, inventory, color , price,lat, lng,tel  from( "
					+ "			select rownum n, name ,addr, inventory, color , price,lat, lng,tel "
					+ "			from("+sql2+")) "
					+ "			where n between ? and ?";
 
				
 		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new YososuVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getString(8)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	public YososuVO getYososu(String name) {
		YososuVO y = null;
		String sql ="select * from yososu where name=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				y= new YososuVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getString(8));						
						
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return y;
	}
}



