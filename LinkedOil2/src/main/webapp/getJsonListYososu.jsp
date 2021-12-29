<%@page import="com.google.gson.Gson"%>
<%@page import="com.linkedoil.vo.YososuVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<YososuVO> list = (ArrayList<YososuVO>)session.getAttribute("list");
	Gson gson = new Gson();
	String str = gson.toJson(list);
%>
<%= str %>