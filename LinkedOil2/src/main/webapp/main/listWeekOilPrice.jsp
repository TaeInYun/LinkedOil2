<%@page import="com.google.gson.Gson"%>
<%@page import="com.linkedoil.vo.WeekAvgOilPriceVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" %>

	<%!
		public String getTagValue(String tag, Element ele) {
	        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
	        Node nValue = (Node) nodeList.item(0);
	        if(nValue == null) {
	            return null;
	        }
	        return nValue.getNodeValue();
   		}	
	%>
	<%
  	 	ArrayList<WeekAvgOilPriceVO> list = new ArrayList<WeekAvgOilPriceVO>(); 
		String serviceKey = "F211201253";
	try {
    	//open api url	
    	String url="http://www.opinet.co.kr/api/avgRecentPrice.do?out=xml&code="+serviceKey;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url);

        //root tag
        doc.getDocumentElement().normalize();
        
        // parsing tag -
        NodeList nodeList = doc.getElementsByTagName("OIL");
        
        for(int temp =0; temp<nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            
            if(nNode.getNodeType()==Node.ELEMENT_NODE){
               
            	Element element = (Element) nNode;
            	
            	String date = getTagValue("DATE", element);
            	String oil_code = getTagValue("PRODCD", element);
            	String price = getTagValue("PRICE", element);
            	
            	WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO(date, oil_code, Double.parseDouble(price));
            	list.add(vo);
            }//if

        }//for nodelist
        
	} catch (Exception e) {
	    e.printStackTrace();
	}
	Gson gson = new Gson();
  	String str = gson.toJson(list);
	%>
  	<%= str %>
