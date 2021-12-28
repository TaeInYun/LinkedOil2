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
    
    
    //주간 평균유가정보를 불러와 테이블에 레코드삽입하기
   public static void main(String[] args) {

    	//서비스키
        String serviceKey = "F211201253";

        try {
            	//open api url	
            	String url="http://www.opinet.co.kr/api/avgLastWeek.do?prodcd=&code="+serviceKey+"&out=xml";

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());

                
                // parsing tag -
                NodeList nodeList = doc.getElementsByTagName("OIL");
                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());
                
                
                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	
                    	String oil_code = getTagValue("PRODCD", element);
                    	String date = getTagValue("WEEK", element);
                    	double price = Double.parseDouble(getTagValue("PRICE", element));
                    	String week= "";
                    	
                    	String year = date.substring(0, 4) + "년";
                    	String month = date.substring(4,6) +"월";
                    	String day = date.substring(6,7) + "주";
                    	week = year + month + day;
                    	
                    	WeekAvgOilPriceVO oil = new WeekAvgOilPriceVO(week,oil_code,price);
                    	int re = new WeekAvgOilPriceDAO().insertWeekAvgOilPrice(oil);
                    	
                    	if(re == 1) {
                    		System.out.println("레코드 삽입 성공");
                    	}else {
                    		System.out.println("레코드 삽입 실패");
                    	}
                    }//if
                }//for nodelist
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//main
    
    
}
