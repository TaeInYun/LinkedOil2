package com.linkedoil.xml;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

 

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import com.linkedoil.dao.EvChargerDAO;
import com.linkedoil.dao.EvstationDAO;
import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.EvChargerVO;
import com.linkedoil.vo.EvStationVO;


public class ReadEvStation {

    //item 정보를 가져오는 메소드 
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
        String serviceKey = "lHOuhUKvqa9uj6vzR1BlT9B6AwrKrIKDIQXtIyovn4m6eaHXcokr3tDyfdgVAwK7B3NwWYE1bhM2wZADHMsaGA%3D%3D";

        int page =1; //페이지 초기값
    	//String []address= {"서울특별시","부산광역시","대구광역시","인천광역시","광주광역시","대전광역시","울산광역시","세종특별자치시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주특별자치도"};
      //  int i = 0;
       
        try {
        	
            while(true) {
            	//open api url	
            	String url="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?"
            			+ "serviceKey="+serviceKey
            			+"&pageNo="+page
            			+"&numOfRows=1000";
            	

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());
                
                // parsing tag
                NodeList nodeList = doc.getElementsByTagName("item");
                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	System.out.println(getTagValue("csId", element));
                    	
                    	//VO에 값 담기
                        EvStationVO e = new EvStationVO();
                        e.setEv_id(Integer.parseInt(getTagValue("csId", element))); //충전소아이디
                        e.setEv_name(getTagValue("csNm", element));  //충전소명
                        e.setEv_addr(getTagValue("addr", element)); //충전소 주소
                        e.setEv_x(Double.parseDouble(getTagValue("lat", element)));  //위도
                        e.setEv_y(Double.parseDouble(getTagValue("longi", element)));  //경도                    		

                     //insert메소드 호출
                        EvstationDAO dao = new EvstationDAO();
                        int re =   dao.insertEvstation(e);
                    	if(re==1) {
            				System.out.println("레코드 생성 성공");
            			}else {
            				System.out.println("레코드 생성 실패");
            			}
                    	
                    	
                    }//if
                   

                } //for nodelist

                page += 1;
                if(page >3) {
  	              break;
                }   


            }//while
            
      
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main

    
    
}