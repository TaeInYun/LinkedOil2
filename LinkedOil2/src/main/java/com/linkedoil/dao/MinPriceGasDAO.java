package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.GasStationVO;
import com.linkedoil.vo.MinPriceGasVO;

public class MinPriceGasDAO {
	
	 
	 public ArrayList<MinPriceGasVO>minPriceGasList(){
		 ArrayList<MinPriceGasVO>minList = new ArrayList<MinPriceGasVO>();
		 
		 try {
				Connection conn = ConnectionProvider.getConnection();
				
				String sql =  "SELECT station_no, station_local, station_name, station_addr, oil_b027 FROM  ( SELECT * FROM gas_station ORDER BY oil_b027) WHERE ROWNUM < 10 and oil_b027 not in 0 "; 
				 
				PreparedStatement pstmt = conn.prepareStatement(sql);
				 
				 
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					minList.add(new MinPriceGasVO(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)						
							));			
				}
				ConnectionProvider.close(conn, pstmt, rs);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			return minList;
		}
}