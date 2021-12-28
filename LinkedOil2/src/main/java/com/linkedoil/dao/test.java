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

    //item ������ �������� �޼ҵ� 
    private static String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);
        if(nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }// getTagValue
    
    
    //������ �����а� �μ�Ʈ�޼ҵ� ����
   public static void main(String[] args) {

    	//����Ű
        String serviceKey = "F211201253";

        int page =1; //������ �ʱⰪ
       
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
                //getTagValue("xml�� �ߴ� ������ ����ִ� �׷��±��̸�..????", element) 
                NodeList nodeList = doc.getElementsByTagName("item");
                System.out.println("�Ľ��� ����Ʈ �� : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
		//getTagValue("�ش� �±��̸�", element)
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