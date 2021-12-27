package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.GasStationVO;
 

public class GasDAO {
	
	public static int pageSize = 10;  
	public static int totalRecord; 
	public static int totalPage;  
	
	public int getTotalRecord(String sido1, String gugun1, String user_brand) {
		int n= 0 ;
		String sql ="select count(*) from gas ";		
		
		if(sido1 != null && gugun1 != null) {
			sql += "  where brand like '%"+user_brand+"%'  and local like '%"+sido1+"%'  and local like '%"+gugun1+"%'    ";
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


	public ArrayList<GasStationVO> listgas(int pageNUM, String sido1, String gugun1, String user_brand, String oil){
		
				totalRecord =  getTotalRecord(sido1, gugun1,user_brand);
				totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
				System.out.println("전체 데이터 :"+totalRecord);
				System.out.println("전체 페이지"+totalPage);
				
				int start =(pageNUM-1)*GasDAO.pageSize+1;
				int end = start +GasDAO.pageSize-1;
				
				System.out.println("start"+start);
				System.out.println("end"+end);
				
				
				ArrayList<GasStationVO> list = new ArrayList<GasStationVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql2 = "select * from gas";
			
			
			if(sido1 != null && gugun1 != null) {
				sql2 += "  where brand like '%"+user_brand+"%'  and local like '%"+sido1+"%'  and local like '%"+gugun1+"%'    ";
			}
			 
			String sql = "select no1 ,no2, local, name , addr, brand, self ,oil_price_b034 ,oil_price_b027 ,oil_price_d047 ,oil_price_c004 from( "
					+ "			select rownum n, no1 ,no2, local, name , addr, brand, self ,oil_price_b034 ,oil_price_b027, oil_price_d047 ,oil_price_c004 "
					+ "			from("+sql2+")) "
					+ "			where n between ? and ?";
 
				if(oil != null) { 
					 sql = "select no1 ,no2, local, name , addr, brand, self ,oil_price_b034 ,oil_price_b027 ,oil_price_d047 ,oil_price_c004 from( "
								+ "			select rownum n, no1 ,no2, local, name , addr, brand, self ,oil_price_b034 ,oil_price_b027, oil_price_d047 ,oil_price_c004 "
								+ "			from("+sql2+" order by "+oil+" )) "
								+ "			where n between ? and ?";
				}
 		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GasStationVO(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),					
						rs.getString(6),			
						rs.getString(7),			
						rs.getString(8),			
						rs.getString(9),			
						rs.getString(10),		
						rs.getString(11)						
						));
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		}catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return list;
	}
	
	public GasStationVO getGas(String no2) {
		GasStationVO g = null;
		String sql ="select * from gas where no2=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no2);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				g= new GasStationVO( 
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),					
						rs.getString(6),			
						rs.getString(7),			
						rs.getString(8),			
						rs.getString(9),			
						rs.getString(10),		
						rs.getString(11)
						);						
						
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		
		return g;
	}
	
}
