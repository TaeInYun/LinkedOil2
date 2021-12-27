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
    		String url="https://www.opinet.co.kr/api/avgRecentPrice.do?out=xml&code="+serviceKey+"&prodcd=D047";
			
    		if((String)request.getAttribute("oil_code") != null){
				String re = (String)request.getAttribute("oil_code");
				String prodcd = re.substring(1, 5);
    			url="https://www.opinet.co.kr/api/avgRecentPrice.do?out=xml&code="+serviceKey+"&prodcd="+prodcd;
			}
    		
    	//open api url	
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
            	String oil_code = getTagValue("PRODCD", element);
	            String price = getTagValue("PRICE", element);
            	String month = getTagValue("DATE", element).substring(4, 6);
            	String date = getTagValue("DATE", element).substring(6, 8);
            	String str = month + "/" + date;
            	
            	if(oil_code.equals("B027")){
            		oil_code="휘발유";
	            	WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO(str, oil_code, Double.parseDouble(price));
	            	list.add(vo);
            	}else if(oil_code.equals("D047")){
            		oil_code="경유";
	            	WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO(str, oil_code, Double.parseDouble(price));
	            	list.add(vo);
            	}else if(oil_code.equals("B034")){
            		oil_code="고급휘발유";
	            	WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO(str, oil_code, Double.parseDouble(price));
	            	list.add(vo);
            	}else if(oil_code.equals("K015")){
            		oil_code = "LPG";
	            	WeekAvgOilPriceVO vo = new WeekAvgOilPriceVO(str, oil_code, Double.parseDouble(price));
	            	list.add(vo);
            	}
            }//if

        }//for nodelist
        
	} catch (Exception e) {
	    e.printStackTrace();
	}
	Gson gson = new Gson();
  	String str = gson.toJson(list);
	%>
  	<%= str %>
