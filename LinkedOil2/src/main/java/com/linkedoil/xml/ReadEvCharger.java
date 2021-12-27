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

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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


public class ReadEvCharger {
	
	//ArrayList<String> ev_id = new Array
	
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
        String serviceKey = "lHOuhUKvqa9uj6vzR1BlT9B6AwrKrIKDIQXtIyovn4m6eaHXcokr3tDyfdgVAwK7B3NwWYE1bhM2wZADHMsaGA%3D%3D";

        int page =2; //������ �ʱⰪ
    	//String []address= {"����Ư����","�λ걤����","�뱸������","��õ������","���ֱ�����","����������","��걤����","����Ư����ġ��","��⵵","������","��û�ϵ�","��û����","����ϵ�","���󳲵�","���ϵ�","��󳲵�","����Ư����ġ��"};
      //  int i = 0;
       
        try {
        	
            while(true) {
            	//open api url	
            	String url="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?"
            			+ "serviceKey="+serviceKey
            			+"&pageNo="+page
            			+"&numOfRows=200";
            	

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());
                
                // parsing tag
                NodeList nodeList = doc.getElementsByTagName("item");
                System.out.println("�Ľ��� ����Ʈ �� : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	System.out.println(getTagValue("csId", element));            
                    	
                    	//������VO
                    	EvChargerVO evcharger = new EvChargerVO();
    	        		evcharger.setEv_id(Integer.parseInt(getTagValue("csId", element))); //������id	  
    	        		evcharger.setCharger_id(Integer.parseInt(getTagValue("cpId", element))); //������id
    	        		evcharger.setCharger_name(getTagValue("cpNm", element));  //�������̸�
    	        		evcharger.setCharger_type(Integer.parseInt(getTagValue("chargeTp", element))); //Ÿ��
    	        		evcharger.setCharger_status_code(Integer.parseInt(getTagValue("cpStat", element))); //����
    	        		evcharger.setCharger_method_no(Integer.parseInt(getTagValue("cpTp", element))); //���      		
    	        		
    	        		EvChargerDAO chargerdao = new EvChargerDAO();
    	        		int re1 = chargerdao.insertEvCharger(evcharger);
    	        		if(re1==1) {
            				System.out.println("���ڵ� ���� ����");
            			}else {
            				System.out.println("���ڵ� ���� ����");
            			}
                    	
                    }//if

                } //for nodelist
                
                page += 1;
                if(page >35) {
  	              break;
                }   

            }//while
            
      
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main

    
    
}

