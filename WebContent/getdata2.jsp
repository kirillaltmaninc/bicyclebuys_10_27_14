<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%>
<%@ page import="com.admin.action.*"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
		String state_abbr = request.getParameter("state_abbr");
		float total = Float.parseFloat(request.getParameter("total")); 
		
		String stateAbbrevation = obj.getStateAbbrevation(state_abbr);		
		float taxRate = obj.getTax(stateAbbrevation); 
		
		
		float taccalculate=(total * taxRate)/100;
		
		float ftotal=total + taccalculate;
		
		System.out.println("naveen jeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee--->"+ftotal +"SATATE--->"+state_abbr);
		
	%>
	 
</body>
</html>