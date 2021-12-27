package com.linkedoil.xml;

import java.net.URLDecoder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import com.linkedoil.dao.LocalDAO;
import com.linkedoil.vo.LocalVO;

 

public class ReadLocal {

    //local ������ �������� �޼ҵ� 
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

       // int area =00; //���� �ʱⰪ

        try {
            	//open api url	
            	String url="http://www.opinet.co.kr/api/areaCode.do?out=xml&code="+serviceKey+"&area=00";

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());

                
                // parsing tag -
                NodeList nodeList = doc.getElementsByTagName("OIL");
                System.out.println("�Ľ��� ����Ʈ �� : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){
                       
                    	Element element = (Element) nNode;
                    	
                        //VO�� �� ���
                        LocalVO local = new LocalVO();
                        local.setLocal_code(Integer.parseInt(getTagValue("AREA_CD", element))); //�����Ҿ��̵�
                        local.setLocal_name(getTagValue("AREA_NM", element));  //�����Ҹ�
                        
                        
                        //insert�޼ҵ�
                        LocalDAO dao = new LocalDAO();
                        int re = dao.insertLocal(local);
                    	if(re==1) {
            				System.out.println("���ڵ� ���� ����");
            			}else {
            				System.out.println("���ڵ� ���� ����");
            			}
                        
                    }//if

                }//for nodelist

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main
    
    
    
    
    
}
