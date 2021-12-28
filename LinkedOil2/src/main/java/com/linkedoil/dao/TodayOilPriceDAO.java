package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.linkedoil.dao.WeekAvgOilPriceDAO;
import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.TodayOilVO;
import com.linkedoil.vo.WeekAvgOilPriceVO;

public class TodayOilPriceDAO {
	
	 //local ������ �������� �޼ҵ� 
    private static String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);
        if(nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }// getTagValue
    
    //������ ������������� �ҷ����� �޼ҵ�
    public static double getLastMonthAvgOilPrice(String oil_code) {
    	 double avg_price = 0;
         
     	Calendar today = Calendar.getInstance();
     	int month = today.get(Calendar.MONTH);
     	
     	String sql = "select avg(price) from WeekAvgOilPrice where oil_code='"+oil_code+"'and substr(week,6,2)='"+month+"'";
     	Connection conn = ConnectionProvider.getConnection();
     	Statement stmt = null;
     	ResultSet rs = null;
     	
     	try {
     		stmt = conn.createStatement();
     		rs = stmt.executeQuery(sql);
     		
     		if(rs.next()) {
     			avg_price = rs.getDouble(1);
     		}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     	return avg_price;
    	
    }
    
    //������ ������������� �ҷ����� �޼ҵ�
    public static double getLastWeekAvgOilPrice(String oil_code){
        double avg_price = 0;
        
    	Calendar today = Calendar.getInstance();
    	int week = today.get(Calendar.WEEK_OF_MONTH)-1;
    	int month = today.get(Calendar.MONTH);
    	
    	if(week == 0) {
    		today.set(Calendar.MONTH,month-1);
    		week = today.get(Calendar.WEEK_OF_MONTH);
    	}
    	
    	month = today.get(Calendar.MONTH) + 1;
    	
    	String sql = "select price from WeekAvgOilPrice where oil_code='"+oil_code
    					+"' and substr(week,9,1)="+ week 
    					+" and substr(week,6,2)="+month;
    	Connection conn = ConnectionProvider.getConnection();
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			avg_price = rs.getDouble(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return avg_price;
    }
    
    //���� �������� api�� �а� ������ TodayOilVO�� ��ȯ�ϴ� �޼ҵ�
    public ArrayList<TodayOilVO> listTodayOil() {

     	//����Ű
         String serviceKey = "F211201253";
         ArrayList<TodayOilVO> list = new ArrayList<TodayOilVO>();
         try {
             	//open api url	
             	String url="http://www.opinet.co.kr/api/avgAllPrice.do?out=xml&code=" + serviceKey;

                 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                 DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                 Document doc = dBuilder.parse(url);

                 //root tag
                 doc.getDocumentElement().normalize();
                 // parsing tag -
                 NodeList nodeList = doc.getElementsByTagName("OIL");
                 
                 for(int temp =0; temp<nodeList.getLength(); temp++) {
                     Node nNode = nodeList.item(temp);
                     
                     if(nNode.getNodeType()==Node.ELEMENT_NODE){
                        
                     	Element element = (Element) nNode;
                     	
                     	String oil_name = getTagValue("PRODNM", element);
                     	double price = Double.parseDouble(getTagValue("PRICE", element));
                     	
                     	String diff = getTagValue("DIFF", element);
                     	String oil_code = getTagValue("PRODCD", element);
                     	
                     	if(!oil_name.equals("�ǳ�����")) {
                     		
                     		if(oil_name.equals("�ڵ��������")) {
                     			oil_name = "����";
                     		}
                     		if(oil_name.equals("�ڵ������ź")) {
                     			oil_name = "LPG";
                     		}
                     		
                     		TodayOilVO today = new TodayOilVO(oil_name, price, diff);
                     		double lastWeek_price = getLastWeekAvgOilPrice(oil_code);
                     		double lastMonth_price = getLastMonthAvgOilPrice(oil_code);
                     		
                     		double lastweek_diff = Math.round( (price - lastWeek_price)*100 ) /100.0;
                     		double lastmonth_diff = Math.round( (price - lastMonth_price)*100 )/100.0;
                     		today.setWeek_diff(lastweek_diff);
                     		today.setMonth_diff(lastmonth_diff);
                     		
                     		list.add(today);
                     	}
                     }//if
                 }//for nodelist
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return list;
    }
}
