<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<body>
   
  <div class="container">
 	  <div class="clients">
  <p><img src="images/border.JPG" width="959" height="7"> </p>
   
   
   
   <table width="100%"   cellspacing="0" cellpadding="0">
      <tr>
        <td><a href="getmyaccount?uid=<%=session.getAttribute("uid")%>"><font color="green"><b>Order Details</b> </font> </a>  |  <a href="getmyprofile?uid=<%=session.getAttribute("uid")%>"><font color="green"><b>View Profile</b></font></a> </td> 
      </tr>
    </table>
    <div style="clear: both; height: 15px;" ></div>
   
     <div class="login1234">
    <h1>All Product Order Details</h1>
    <ul class="formlist">  
      <table width="100%" border="1">
  <tbody><tr>
    <td width="8%">&nbsp;Image</td>
    <td width="25%">&nbsp;SKU</td>
    <td   width="15%">Descriptions</td>
     <td width="15%"> Quentity  </td>
    <td   width="15%">Price</td>   
    <td width="15%">Total </td> 
  </tr>
  
  <%@ page import="com.admin.action.*" %>
 <%@ page import="java.util.*" %> <%@ page import="java.text.*" %>
 
 <%
 
 DecimalFormat twoDForm = new DecimalFormat("#0.00");
	float totalval=0; 
	float tax=0;
	float couponval=0;
 %>
    <% 
					ArrayList viewproductorderwise=(ArrayList)request.getAttribute("viewproductorderwise");
					if(!viewproductorderwise.isEmpty())
                        {  	
                        for(int i=0;i<viewproductorderwise.size();i++)
                         { 
                        	productDTO e=(productDTO)viewproductorderwise.get(i); 
                        	
                          %>   
   <tr>
    <td><img src="productimages/<%=e.getPicturename() %>" alt="" class="productimages"></td>
    <td><%=e.getSKU() %></td>
    <td><%=e.getDescription() %></td>
    <td><%=e.getQty() %></td>
    <td><%=e.getPrice() %></td>
    <td><%=Double.parseDouble(twoDForm.format((((e.getQty()) * (e.getPrice()))))) %></td>  
  </tr> 
  <%if(e.getTax()==0) {%>
     
  <%} else { %>
      <%tax=e.getTax(); %>
  <%} %>
  <%if(e.getCookiesvalue().equals("0")) {%>
      <%couponval=0;%>
  <%} else { %>
      <%couponval=Float.parseFloat(e.getCookiesvalue()); %> 
  <%} %>
  
  
 <%totalval= totalval+ (e.getQty()) * (e.getPrice());}} %> 
  
  <%if(!(tax==0)) { %>
     <tr align="right"> 
	    <td align="right">
	      <strong style="color: red;"> Tax</strong>
	    </td>
	    <td align="right">$<%=tax %><%totalval=totalval+tax; %></td>
    </tr>
  
  <%} %>
 
  
  <%if(!(couponval==0)) {%>
      <tr align="right"> 
     <td align="right">
      <strong style="color: red;"> Coupon Discount</strong>
      </td>
       <td align="right">$<%=couponval %>  <%totalval=totalval-couponval;; %></td>
   </tr>
  <%} %> 
 
  
  <tr align="right"> 
    <td align="right">
      <strong style="color: red;"> Sub Total</strong>
    </td>
    <td align="right">$<%=Double.parseDouble(twoDForm.format(((totalval)))) %></td>
  </tr>
  
 
        </tbody></table>
 
    </ul>
  </div>
 
   
  
 </div> 
 </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>