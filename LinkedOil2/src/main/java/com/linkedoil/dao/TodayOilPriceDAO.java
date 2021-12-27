package com.linkedoil.dao;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.linkedoil.dao.WeekAvgOilPriceDAO;
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
                 System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());

                 
                 // parsing tag -
                 NodeList nodeList = doc.getElementsByTagName("OIL");
                 System.out.println("�Ľ��� ����Ʈ �� : "+ nodeList.getLength());
                 
                 
                 for(int temp =0; temp<nodeList.getLength(); temp++) {
                     Node nNode = nodeList.item(temp);
                     
                     if(nNode.getNodeType()==Node.ELEMENT_NODE){
                        
                     	Element element = (Element) nNode;
                     	
                     	String oil_name = getTagValue("PRODNM", element);
                     	double price = Double.parseDouble(getTagValue("PRICE", element));
                     	String diff = getTagValue("DIFF", element);
                     	
                     	TodayOilVO today = new TodayOilVO(oil_name, price, diff);
                     	list.add(today);
                     }//if
                 }//for nodelist
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return list;
    }
}
