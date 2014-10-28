<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		 
		
		
		String cartid = request.getParameter("cartID");
		System.out.println("inside delete jsp cartid --> " + cartid);
		
		String userId = null;
		Dbconnect db = new Dbconnect();
		try {
			Statement st = db.dbconnect();
			st.executeUpdate("delete from Cartdetails where cid='"+cartid+"'");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			db.close();
		}
	%>





</body>
</html>