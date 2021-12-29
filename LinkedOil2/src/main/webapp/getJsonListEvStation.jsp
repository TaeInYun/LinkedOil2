<%@page import="com.linkedoil.vo.SearchStationVO"%>
<%@page import="com.linkedoil.vo.GasStationVO"%>
<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<SearchStationVO> list = (ArrayList<SearchStationVO>)session.getAttribute("list");
	Gson gson = new Gson();
	String str = gson.toJson(list);
%>
<%= str %>