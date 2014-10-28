<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%>
<%@ page import="java.util.*"%>
<%@ page import="com.admin.action.*"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%
		String state_abbr = request.getParameter("state_abbr");
		float total = Float.parseFloat(request.getParameter("total"));
		 System.out.println("inside getdata for checkout");
				 
		 String uid = (String)session.getAttribute("uid");	 
		 String bookingcode = "";
         String cookieName = "BICYCLE";
         Cookie[] cookies = request.getCookies();
         if (cookies != null) {
           for (int i = 0; i < cookies.length; i++) {
             if (cookies[i].getName().equals(cookieName))
             {
               System.out.println("COOKIES AVAILABLE--->" + 
                 cookies[i].getName());
               bookingcode = cookies[i].getValue();
               System.out.println("COOKIES VALUE--->" + bookingcode);
             }
           }
         }
		 ArrayList carddetails = obj.getcartdetails(bookingcode, uid);
          	String overwaight;	
          	float fprice=0;
          Dbconnect db = new Dbconnect();
    	  Statement st = db.dbconnect();
    	  
    	  Statement st2 = db.dbconnect();
    	  Statement st3 = db.dbconnect();
          	
    	 int ov1n; 
         boolean b=false;
    	  
    	 int ov1=0,ov2=0,ov3=0,ov4=0; 
         
         for (int i = 0; i < carddetails.size(); i++)
	      {   
			 productDTO dt = (productDTO)carddetails.get(i);		     
			
			 ResultSet rs2=st2.executeQuery("select * from products where ProdID='"+dt.getPid()+"'");
			 if(rs2.next())
			 {
				 overwaight=rs2.getString("OverWeight");
				 if(overwaight.equals("1")) 
				 {
					 ov1=ov1+ dt.getQty(); 
					 b=true;
				 }
				 if(overwaight.equals("2")) 
				 {
					 ov2=ov2+ dt.getQty();
					 b=true;
				 }
				 
				 if(overwaight.equals("3")) 
				 {
					 ov3=ov3+ dt.getQty();
					 b=true;
				 }
				/* 
				 if(overwaight.equals("4")) 
				 {
					 ov4=ov4+ dt.getQty();
					 b=true;
				 } */
			 }			 
	      }
		 
		 
		
	%>
<body > 


<%
if(b==false)
 {
	String query="select sm.ShippingMethod,scz.ShippingCost from ShippingCostPerZone scz,State s,ShippingStateZones sz,[Shipping Methods] as sm where scz.Zone=sz.Zone and sz.State= s.abbreviation and s.State='"+state_abbr+"' and scz.ShippingType in (7,11,12) and scz.PurchasePriceLow<='"+total+"' and scz.PurchasePriceHigh>='"+total+"' and sm.ShippingMethodID=scz.ShippingType ORDER BY ShippingCost ASC";
  %>
 <table>
		<tr>
			<td><b>SHIPPER</b></td>
			<td><b>COST</b></td>
		</tr> 
		<%ResultSet rs = st.executeQuery(query);
		  while(rs.next())
		  { %> 
		<tr>
		  <td><%=rs.getString("ShippingMethod") %></td>
		  <td>$ <%=rs.getString("ShippingCost") %></td>
		</tr>
		
		<% } %> 
		<%db.close(); %>
	</table>
 <%} else {%><%

ResultSet rs3=st3.executeQuery("select TrainersCost as ov1,WheelsCost as ov2,o.BikesCost as ov3,o.ShippingType as stype,m.ShippingMethod from State as s, ShippingStateZones z,OverweightCostPerZone o,  [Shipping Methods] m where s.abbreviation =z.State and z.Zone=o.Zone and o.ShippingType=m.ShippingMethodID and s.State='"+state_abbr+"' ORDER BY o.ShippingType ASC") ; 
 
%>
<table>
		<tr>
			<td><b>SHIPPER</b></td>
			<td><b>COST</b></td>
		</tr> 
		<% 
		  while(rs3.next())
		  { %> 
		<tr> 
		  <%  
		  float ov1p=Float.parseFloat(rs3.getString("ov1")) * ov1;
		  float ov2p=Float.parseFloat(rs3.getString("ov2")) * ov2;
		  float ov3p=Float.parseFloat(rs3.getString("ov3")) * ov3; 
	  %> 
	<tr>
	  <td><%=rs3.getString("ShippingMethod") %></td> 
		  <td>$ <%=ov1p+ov2p+ov3p %></td>
		</tr> 
		<% } %> 
		<%db.close(); %>
	</table>
<%} %>

	
</body>
</html>