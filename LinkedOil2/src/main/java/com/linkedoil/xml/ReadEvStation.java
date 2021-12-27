package com.linkedoil.xml;

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import com.linkedoil.vo.EvChargerVO;
import com.linkedoil.vo.EvStationVO;



public class ReadEvStation {
	
	static ArrayList<EvStationVO> EvStationlist = new ArrayList<EvStationVO>();
	static ArrayList<EvChargerVO> EvChargerlist = new ArrayList<EvChargerVO>();
	

    //item ������ �������� �޼ҵ� 
    private static String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);
        if(nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }// getTagValue
    
    public static void main(String[] args) {


   // public static void getEvstationAPI() {

    	//����Ű
        String serviceKey = "8SMqToM5fi5G6orHE75UaxVTf1IC43Yx%2Bn3UG7RnYFaeHYuNyZLr835P6kLf%2FcOPMxQHZFcSBK5z0koBco6XDQ%3D%3D";

        int page =1; //������ �ʱⰪ
    	String []address= {"����Ư����","�λ걤����","�뱸������","��õ������","���ֱ�����","����������","��걤����","����Ư����ġ��","��⵵","������","��û�ϵ�","��û����","����ϵ�","���󳲵�","���ϵ�","��󳲵�","����Ư����ġ��"};
        int i = 0;

        try {
        	
        while(true){	
        	String ppage = Integer.toString(page);
            StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(ppage, "UTF-8")); /*��������ȣ*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*�� ������ ��� ��*/
            urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode(address[i], "UTF-8")); /*�˻���� �������ּ�*/	
            String url = urlBuilder.toString();
            
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
                
              //������VO
                EvStationVO e = new EvStationVO();
                e.setEv_id(Integer.parseInt(getTagValue("csId", element))); //�����Ҿ��̵�
                e.setEv_name(getTagValue("csNm", element));  //�����Ҹ�
                e.setEv_addr(getTagValue("addr", element)); //������ �ּ�
                e.setEv_x(Double.parseDouble(getTagValue("lat", element)));  //����
                e.setEv_y(Double.parseDouble(getTagValue("longi", element)));  //�浵
                EvStationlist.add(e);
                for(EvStationVO ev :  EvStationlist) {
                System.out.println(ev);
                }
               

                	
             //������VO
                EvChargerVO evcharger = new EvChargerVO();
        		evcharger.setCharger_id(Integer.parseInt(getTagValue("cpId", element))); //������id
        		evcharger.setCharger_name(getTagValue("cpNm", element));  //�������̸�
        		evcharger.setCharger_type(Integer.parseInt(getTagValue("chargeTp", element))); //Ÿ��
        		evcharger.setCharger_status_code(Integer.parseInt(getTagValue("cpStat", element))); //����
        		evcharger.setCharger_method_no(Integer.parseInt(getTagValue("cpTp", element))); //���
        		evcharger.setCharger_time_renuewal(getTagValue("statUpdateDatetime", element));//���ų�¥
        		evcharger.setEv_id(Integer.parseInt(getTagValue("csId", element))); //������id
        		EvChargerlist.add(evcharger);
	            
                }
            }//for
                page += 1;
	           if(page >5) {
	              i+=i;
	             page=1;
	           }
	           
               if(i>address.length) {
            	   break;
               }
        }//while
        

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//main
}


