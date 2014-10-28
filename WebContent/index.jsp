<%@page import="java.util.ArrayList"%>
<%@page import="com.admin.item.Item"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Random"%>
 
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
ArrayList previously=new ArrayList(); 
session.setAttribute("previously", previously);
%>
<% 
String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String proj="BICYCLEBUYSCOM";
int character=(int)(Math.random()*20);
String s=alphabet.substring(character, character+4); 
Random r = new Random();
int Low = 100;
int High = 1000;
int R = r.nextInt(High-Low) + Low;  		  
System.out.println(proj.substring(0, 3) + "->"  +s+"-->"+R); 

String bookingcode=proj.substring(0, 3)+s+R;
System.out.println("Final code is->"+bookingcode);

String cookieName = "BICYCLE";
Cookie cookies [] = request.getCookies ();
Cookie myCookie = null;
boolean b=false;
if (cookies != null)
{
	for (int i = 0; i < cookies.length; i++) 
	{
		if (cookies [i].getName().equals (cookieName))
		{					
			myCookie = cookies[i];
			System.out.println(cookies[i]); 
			bookingcode=myCookie.getValue();
			System.out.println("+++++++++++++++++++++++++++++++++"+bookingcode); 
			b=true;
			break;
		} 
	}
	if(b==false)
	{ 
		System.out.println("CREATING NEW COOKIES--");
		Cookie cookie = new Cookie (cookieName,bookingcode);				 
		response.addCookie(cookie);
	}
}
else
{
	System.out.println("in side cookiess not available");
	Cookie cookie = new Cookie (cookieName,bookingcode);				 
	response.addCookie(cookie);
}

%> 
 
<%response.sendRedirect("indexpage"); %>

</body>
</html>