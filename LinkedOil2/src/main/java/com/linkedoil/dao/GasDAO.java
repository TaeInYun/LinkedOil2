package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.GasStationVO;
 

public class GasDAO {
	
	public static int pageSize = 5;  
	public static int totalRecord; 
	public static int totalPage;  
	
	public static int pageGroup = 5; // 한 화면에 보여줄 페이지의 수를 10개씩
	
	public static int startPage;
	public static int endPage;
	
	public int getTotalRecord(String sido1, String gugun1, String user_brand) {
		int n= 0 ;
		String sql ="select count(*) from gas_station ";		
		
		if(sido1 != null && gugun1 != null) {
			sql += "  where station_brand like '%"+user_brand+"%'  and station_local like '%"+sido1+"%'  and station_local like '%"+gugun1+"%'    ";
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
				
				int start =(pageNUM-1)*GasDAO.pageSize+1;
				int end = start +GasDAO.pageSize-1;
				
				
				startPage = (int)Math.floor( (pageNUM-1)/pageGroup) *pageGroup + 1;
				endPage = startPage + pageGroup - 1;

				System.out.println("startPage:"+startPage);
				System.out.println("endPage:"+endPage);
				
				// 추가로 조건 설정
				if( totalPage < pageNUM) {
					pageNUM = totalPage;
				}

				if ( endPage > totalPage) {
				endPage = totalPage;
				}
				
				
				ArrayList<GasStationVO> list = new ArrayList<GasStationVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql2 = "select * from gas_station";
			
			
			if(sido1 != null && gugun1 != null) {
				sql2 += "  where station_brand like '%"+user_brand+"%'  and station_local like '%"+sido1+"%'  and station_local like '%"+gugun1+"%'    ";
			}
			 
			String sql = "select station_num ,station_no, station_local, station_name , station_addr,station_brand, station_self ,oil_b037 ,oil_b027 ,oil_d047 ,oil_c004 from( "
					+ "			select rownum n, station_num ,station_no, station_local, station_name , station_addr,station_brand, station_self ,oil_b037 ,oil_b027 ,oil_d047 ,oil_c004 "
					+ "			from("+sql2+")) "
					+ "			where n between ? and ?";
 
				if(oil != null) { 
					 sql = "select station_num ,station_no, station_local, station_name , station_addr,station_brand, station_self ,oil_b037 ,oil_b027 ,oil_d047 ,oil_c004 from( "
								+ "			select rownum n, station_num ,station_no, station_local, station_name , station_addr,station_brand, station_self ,oil_b037 ,oil_b027 ,oil_d047 ,oil_c004 "
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
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	public GasStationVO getGas(String station_no) {
		GasStationVO g = null;
		String sql ="select * from gas_station where station_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, station_no);
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
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return g;
	}
	
}
