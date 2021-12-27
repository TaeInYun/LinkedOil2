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


public class ReadEvStation2 {

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
        String serviceKey = "8SMqToM5fi5G6orHE75UaxVTf1IC43Yx%2Bn3UG7RnYFaeHYuNyZLr835P6kLf%2FcOPMxQHZFcSBK5z0koBco6XDQ%3D%3D";

        int page =1; //������ �ʱⰪ
    	//String []address= {"����Ư����","�λ걤����","�뱸������","��õ������","���ֱ�����","����������","��걤����","����Ư����ġ��","��⵵","������","��û�ϵ�","��û����","����ϵ�","���󳲵�","���ϵ�","��󳲵�","����Ư����ġ��"};
      //  int i = 0;
       
        try {
        	
            while(true) {
            	//open api url	
            	/*String url="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?"
            			+ "serviceKey="+serviceKey
            			+"&pageNo="+page
            			+"&numOfRows=50"+"addr="+address[i];*/
            	
            	String url="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?"
    			+ "serviceKey="+serviceKey
    			+"&pageNo="+page
    			+"&numOfRows=50";

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
                    	System.out.println(getTagValue("csNm", element));
                    	
                    	//VO�� �� ���
                        EvStationVO e = new EvStationVO();
                        e.setEv_id(Integer.parseInt(getTagValue("csId", element))); //�����Ҿ��̵�
                        e.setEv_name(getTagValue("csNm", element));  //�����Ҹ�
                        e.setEv_addr(getTagValue("addr", element)); //������ �ּ�
                        e.setEv_x(Double.parseDouble(getTagValue("lat", element)));  //����
                        e.setEv_y(Double.parseDouble(getTagValue("longi", element)));  //�浵
                        		

                        //insert�޼ҵ� ȣ��
                        EvstationDAO dao = new EvstationDAO();
                       int re =   dao.insertEvstation(e);
                    	if(re==1) {
            				System.out.println("���ڵ� ���� ����");
            			}else {
            				System.out.println("���ڵ� ���� ����");
            			}
                    	
                    /*	 //������VO
    	                EvChargerVO evcharger = new EvChargerVO();
    	        		evcharger.setCharger_id(Integer.parseInt(getTagValue("cpId", element))); //������id
    	        		evcharger.setCharger_name(getTagValue("cpNm", element));  //�������̸�
    	        		evcharger.setCharger_type(Integer.parseInt(getTagValue("chargeTp", element))); //Ÿ��
    	        		evcharger.setCharger_status_code(Integer.parseInt(getTagValue("cpStat", element))); //����
    	        		evcharger.setCharger_method_no(Integer.parseInt(getTagValue("cpTp", element))); //���
    	        		evcharger.setCharger_time_renuewal(getTagValue("statUpdateDatetime", element));//���ų�¥
    	        		evcharger.setEv_id(Integer.parseInt(getTagValue("csId", element))); //������id
    	        		EvChargerlist.add(evcharger);*/
                    	
                    	
                    }//if

                } //for nodelist
                
                page += 1;
                if(page >100) {
             	  break;
                }    

            }//while
            
      
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main

    
    
}
