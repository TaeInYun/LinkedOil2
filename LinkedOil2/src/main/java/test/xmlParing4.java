package test;

import java.net.URLDecoder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

 

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import com.linkedoil.dao.EvstationDAO;
import com.linkedoil.dao.YososuDAO2;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.YososuVO;

 

public class xmlParing4 {

   
    
    //충전소 정보
    public static void main(String[] args) {
    	
   

        try {

     
                //parsing할 url 지정 
            	String url="https://api.odcloud.kr/api/uws/v1/inventory?page=5&perPage=500&returnType=XML&serviceKey=LagRHYY9F38PlpfFZn7yKVVUXJ9NV1LYBaX1SqaA9K1uL7rGHwSJ%2Blb1Fyt8YGi8OkQFehMSvLu2zy4BMIyCJw%3D%3D";// 페이지 수
     
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                //root tag
                doc.getDocumentElement().normalize();

                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());

                // parsing tag
                YososuDAO2 dao = new YososuDAO2();
                NodeList nodeList = doc.getElementsByTagName("item");
                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());

                String name= "";
                String addr = "";
                String inventory  = "";
                String color = "";
                int price = 0;
                double lat = 0;
                double lng = 0;
                for(int temp =0; temp<nodeList.getLength(); temp++) {
                	System.out.println("index:"+temp);
                    Node nNode = nodeList.item(temp);
                    if(nNode.getNodeType()==Node.ELEMENT_NODE) {
                    	Element element = (Element) nNode;
                        System.out.println(element.getTagName());
                        NodeList colList =  element.getElementsByTagName("col");
                        for(int row =0; row<colList.getLength(); row++) {
                        	Node col = colList.item(row);
                        	String attr = col.getAttributes().item(0).getTextContent();  
                        	
                        	if(attr.equals("inventory")) {
                        		inventory = col.getChildNodes().item(0).getNodeValue();
                        		
                        	}
                        	else if(attr.equals("name")) {
                        		name =col.getChildNodes().item(0).getNodeValue();;
                        	}
                        	else if(attr.equals("addr")) {
                        		addr =col.getChildNodes().item(0).getNodeValue();;
                        	}
                        	else if(attr.equals("color")) {
                        		color =col.getChildNodes().item(0).getNodeValue();;
                        	}
                        	else if(attr.equals("price")) {
                        	  if(!col.getChildNodes().item(0).getNodeValue().equals("undefined")) {
                        		  price= Integer.parseInt(col.getChildNodes().item(0).getNodeValue());
                        	  }
                        	}
                        	else if(attr.equals("lat")) {
                        		lat = Double.parseDouble(col.getChildNodes().item(0).getNodeValue());
                        	}
                        	else if(attr.equals("lng")) {
                        		lng = Double.parseDouble(col.getChildNodes().item(0).getNodeValue());
                        	}
                        }
//                    
                     
                       
                      }
                      
                    
                   //YososuVO y = new YososuVO();
                   // new YososuVO();
                    
                    YososuVO y = new YososuVO();
                    new YososuVO(name,addr,inventory,color,price,lat,lng);
                    
                   YososuDAO2 d = new YososuDAO2();
                    d.insertYososuVO(name,addr,inventory,color,price,lat,lng);
                    
                   
                        //VO에 값 담기
//                        new YososuVO(Integer.parseInt(price), )
                      // YososuVO y = new YososuVO(getTagValue("addr", element), Integer.parseInt(getTagValue("inventory", element)),Integer.parseInt(getTagValue("lat", element)),Integer.parseInt(getTagValue("lng", element)),getTagValue("name", element),getTagValue("opentime", element),Integer.parseInt(getTagValue("price", element)),getTagValue("regDt", element),getTagValue("tel", element));
//                      // System.out.println(y);
                       //System.out.println(y.getAddr()); 
                        
                        
                      //  //insert명령어 실행
                  //YososuDAO2 dao = new YososuDAO2();
                	//dao.insertYososuVO(y);
                    	//dao.insertYososuVO(y);

                    }//if

            
             
                

        //    }//while 

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//main
    
    
    
    
    
}
