<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body  >
 
 	<%
		String color1 = request.getParameter("color");
 	String[] splits = color1.split("<>"); 
    String color =  splits[0];;  
     
 	request.setAttribute("abc", color);
 	    System.out.println("color--->"+color);
 	
		int pid =  Integer.parseInt(request.getParameter("pid"));
		 System.out.println("inside getdata for checkout"+request.getParameter("pid") +"-->"+color);
         String query="select pc.ChildProdID,s.Size,c.Color,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid and p.SizeID=s.SizeID and  c.Color='"+color+"' and    ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='"+pid+"'";
		Dbconnect db = new Dbconnect();
		Statement st = db.dbconnect();
		
	%>
	
	<%if(color.equals("")) {%>
	<table>
		<tr>
		  <td> 
		  <div class="color-size"><h2>Size </h2></div>
		  </td>
		  <td> 
		  <div class="color-size1"> 
		  <select name="size" class="dropdown1" style="" id="size1" disabled="disabled"> 
		 
		   <option value="" >Select Size</option>  
		 
		 </select>
		
		 </div>
		 
		 </td> 
		</tr>
		<%db.close(); %>
	</table>
	
	<%} else { %> 
	<table>
		<tr>
		  <td> 
		  <div class="color-size"><h2>Size </h2></div>
		  </td>
		  <td> 
		  <div class="color-size1"> 
		  <select name="size" class="dropdown1" id="size1" onchange="getval(this.value);getproductdetaisl();" style="background: none repeat scroll 0% 0% #F8DBDB;
border: 1px solid #E77776;">  
		  <option value="" >Select Size</option>  
		<%ResultSet rs = st.executeQuery(query);
		  while(rs.next())
		  { %> 
		   <option value="<%=rs.getString("ChildProdID")%><><%=rs.getString("Size")%>"><%=rs.getString("Size") %></option>  
		<% } %>
		 </select>
		 
		 </div>
		 
		 </td> 
		</tr>
		<%db.close(); %>
	</table>
	 
	 <%} %>
</body>
</html>