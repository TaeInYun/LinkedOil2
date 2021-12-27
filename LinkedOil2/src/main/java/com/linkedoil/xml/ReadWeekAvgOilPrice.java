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
                
                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	
                    	String oil_code = getTagValue("PRODCD", element);
                    	System.out.println(oil_code);
                    	
                    	if( oil_code.equals(gas_code) ) {
                    		gas_price += Double.parseDouble( getTagValue("PRICE", element) );
                    	}else if ( oil_code.equals(diesel_code) ) {
                    		diesel_price += Double.parseDouble( getTagValue("PRICE", element) );
						}else if ( oil_code.equals(premium_gas_code) ) {
							premium_gas_price += Double.parseDouble( getTagValue("PRICE", element) );
						}else if ( oil_code.equals(lpg_code) ) {
							lpg_price += Double.parseDouble( getTagValue("PRICE", element) );
						}
                    	/*
                        //VO에 값 담기
                        WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO();
                        vo.setOil_code(getTagValue("PRODCD", element)); 
                       vo.setLocal_name(getTagValue("AREA_NM", element));  //충전소명
                       vo.setGas_price(price);
                       vo.setDiesel_price(price);
                       vo.setPremium_gas_price(price);
                       vo.setLpg_price(price);
                        //insert메소드
                        LocalDAO dao = new LocalDAO();
                        int re = dao.insertLocal(local);
                    	if(re==1) {
            				System.out.println("레코드 생성 성공");
            			}else {
            				System.out.println("레코드 생성 실패");
            			}
                        */
                    }//if

                }//for nodelist
                
                double avg_gas_price = gas_price/7;
                
                
                Calendar today = Calendar.getInstance();
            	int week = today.get(Calendar.WEEK_OF_MONTH);
            	
                System.out.println(avg_gas_price);
                System.out.println(diesel_price);
                System.out.println(premium_gas_price);
                System.out.println(lpg_price);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main
    
    
    
    
    
}
