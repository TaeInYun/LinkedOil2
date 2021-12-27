package com.linkedoil.xml;

import java.net.URLDecoder;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import com.linkedoil.dao.LocalDAO;
import com.linkedoil.dao.WeekAvgOilPriceDAO;
import com.linkedoil.vo.LocalVO;
import com.linkedoil.vo.WeekAvgOilPriceVO;

 

public class ReadWeekAvgOilPrice {

    //local 정보를 가져오는 메소드 
    private static String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);
        if(nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }// getTagValue
    
    
    //충전소 정보읽고 인설트메소드 실행
   public static void main(String[] args) {

    	//서비스키
        String serviceKey = "F211201253";

        try {
            	//open api url	
            	String url="https://www.opinet.co.kr/api/avgRecentPrice.do?out=xml&code=F211201253";

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());

                
                // parsing tag -
                NodeList nodeList = doc.getElementsByTagName("OIL");
                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());
                
                String gas_code = "B027";
                String diesel_code = "D047";
                String premium_gas_code = "B034";
                String lpg_code = "K015";
                
                double gas_price = 0;
                double diesel_price = 0;
                double premium_gas_price = 0;
                double lpg_price = 0;
                
                int year = 0;
                int month = 0;
                int day = 0;
                
                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	
                    	String oil_code = getTagValue("PRODCD", element);
                    	String date = getTagValue("DATE", element);
                    	
                    	String sub_year = date.substring(0, 4);
                    	String sub_month = date.substring(4,6);
                    	String sub_day = date.substring(6,8);
                    	
                    	year = Integer.parseInt(sub_year);
                    	month = Integer.parseInt(sub_month) -1;
                    	day = Integer.parseInt(sub_day);
                    	
                    	//평균을 내기위해 각각의 유가를 유가변수에 더하면서 넣어줌
                    	if( oil_code.equals(gas_code) ) {
                    		gas_price += Double.parseDouble( getTagValue("PRICE", element) );
                    	}else if ( oil_code.equals(diesel_code) ) {
                    		diesel_price += Double.parseDouble( getTagValue("PRICE", element) );
						}else if ( oil_code.equals(premium_gas_code) ) {
							premium_gas_price += Double.parseDouble( getTagValue("PRICE", element) );
						}else if ( oil_code.equals(lpg_code) ) {
							lpg_price += Double.parseDouble( getTagValue("PRICE", element) );
						}
                    	
                    }//if

                }//for nodelist
                
                //레코드 삽입하기위한 변수들
                double avg_gas_price = Math.round(gas_price/7*100) / 100.0;
                double avg_diesel_price = Math.round(diesel_price/7*100) / 100.0;
                double avg_premium_gas_price = Math.round(premium_gas_price/7*100) / 100.0;
                double avg_lpg_price = Math.round(lpg_price/7*100) / 100.0;
                
                Calendar date = Calendar.getInstance();
                date.set(year, month, day);
                int weekOfMonth = date.get(Calendar.WEEK_OF_MONTH) - 1;
                
                String week = date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)+1) + "월" + weekOfMonth + "주";
                
                
                //VO생성
                WeekAvgOilPriceVO gas = new WeekAvgOilPriceVO();
                gas.setWeek(week);
                gas.setPrice(avg_gas_price);
                gas.setOil_code(gas_code);
                
                WeekAvgOilPriceVO diesel = new WeekAvgOilPriceVO();
                diesel.setWeek(week);
                diesel.setPrice(avg_diesel_price);
                diesel.setOil_code(diesel_code);
                
                WeekAvgOilPriceVO premium_gas = new WeekAvgOilPriceVO();
                premium_gas.setWeek(week);
                premium_gas.setPrice(avg_premium_gas_price);
                premium_gas.setOil_code(premium_gas_code);
                
                WeekAvgOilPriceVO lpg = new WeekAvgOilPriceVO();
                lpg.setWeek(week);
                lpg.setPrice(avg_lpg_price);
                lpg.setOil_code(lpg_code);

                //레코드 삽입 메소드 호출
                WeekAvgOilPriceDAO dao = new WeekAvgOilPriceDAO();

                int result_gas = dao.insertWeekAvgOilPrice(gas);
                int result_diesel = dao.insertWeekAvgOilPrice(diesel);
                int result_premium_gas = dao.insertWeekAvgOilPrice(premium_gas);
                int result_lpg = dao.insertWeekAvgOilPrice(lpg);
                
                if(result_gas==1) {
    				System.out.println("휘발유 레코드 생성 성공");
    			}else {
    				System.out.println("휘발유 레코드 생성 실패");
    			}
                
                if(result_premium_gas==1) {
                	System.out.println("고급휘발유 레코드 생성 성공");
                }else {
                	System.out.println("고급 휘발유 레코드 생성 실패");
                }
                if(result_diesel==1) {
                	System.out.println("경유 레코드 생성 성공");
                }else {
                	System.out.println("경유 레코드 생성 실패");
                }
                if(result_lpg==1) {
                	System.out.println("LPG 레코드 생성 성공");
                }else {
                	System.out.println("LPG 레코드 생성 실패");
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main
    
    
    
    
    
}
