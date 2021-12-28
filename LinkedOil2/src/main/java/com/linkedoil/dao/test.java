package com.linkedoil.dao;
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


public class test {

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
        String serviceKey = "F211201253";

        int page =1; //페이지 초기값
       
        try {
        	
            while(true) {
            	//open api url	
            	String url="http://www.opinet.co.kr/api/taxfreeLowTop20.do?out=xml&code=F211201253&prodcd=B127&";

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());
                
                // parsing tag
                //getTagValue("xml에 뜨는 정보를 담고있는 그룹태그이름..????", element) 
                NodeList nodeList = doc.getElementsByTagName("item");
                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
		//getTagValue("해당 태그이름", element)
                    	System.out.println(getTagValue("csId", element));

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