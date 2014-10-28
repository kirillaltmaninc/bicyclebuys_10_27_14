<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"></jsp:include>
 
<body>
 <div class="container">
 	
 	
  
 	<div class="add-to-cart"> 
				<div class="clear"></div>
<div class="table-responsive">
				<div class="Courses1">
 <div class="clear"></div>
 <div class="shipping-center">
  <h1>Order Details</h1>
  
  <%float subtotal=0; %>  
  <%Double tot= (Double)session.getAttribute("subtotal");String t1=String.valueOf(tot);float t=Float.parseFloat(t1);float totalprice=t;%>   
 	<table>
 	  <tbody> 
 	    <tr>
          <td><strong>Sub Total</strong></td>
          <td>$ <%=totalprice%></td>
        </tr>
 	  
 	   <tr>
         <td><strong>Your OrderID is</strong> </td>
         <td><%if(request.getAttribute("orderID")==null) {%> 0<%} else { %>  <font color="blue"> <%=request.getAttribute("orderID") %></font>  <%}%></td>
       </tr> 
        
       <%if(request.getAttribute("taxrate")==null) {%> 
       
       <%} else {%>
         <tr>
          <td><strong>Sales Tax Price Is</strong></td>
          <td>
           <%String taxper=(String)request.getAttribute("taxrate");
            float taxp=Float.parseFloat(taxper); 
            float countval= (totalprice *  taxp)/100;
            totalprice=totalprice+countval; %>
           <%=countval%>
           <%=taxper%></td>
        </tr>
        
        <tr>
          <td><strong>After Shipping tax Applicable</strong></td>
          <td>$ <%=totalprice-taxp%></td>
        </tr>
        
       <%} %>
       
       <%if(session.getAttribute("coupanprice")==null) { %>
        
       <%} else {%>
        <tr>
          <td><strong>Coupon Price is</strong></td>
          <td>$ <%=session.getAttribute("coupanprice")%><%totalprice=totalprice-(Float)session.getAttribute("coupanprice"); %></td>
        </tr>
       <%} %> 
        
       <tr>
         <td><strong>Sub Total</strong></td>
         <td>$ <%=totalprice%></td>
       </tr> 
     </tbody>
 	</table>
 	<%
 	  String svalue=(String)request.getAttribute("stateforship");
 	  ArrayList shippingvia;shippingvia=obj.getshippingvia(totalprice,svalue);request.setAttribute("shippingvia", shippingvia); 
 	%>
 	
 	<h1>Shipping Via</h1>
 	<table width="50%">
 	  <tbody>
 	   <tr>
 	   
 	   
 <script type="text/javascript">
   function getcalculate(a,b)
   {   
	   if(a=="")
	   {
		   document.getElementById('ftot').innerHTML="$ "+b;
		exit;   
	   }
	   var fintotal=parseFloat(a)+ parseFloat(b);  
	   document.getElementById('ftot').innerHTML="$ "+fintotal;
    }
</script>
 	   
         <td><strong>Ship Via</strong> </td>
         <td>
           <select onchange="getcalculate(this.value,<%=totalprice%>)"> 
             <option value="">Choose Shipping</option>
             <c:forEach items="${shippingvia}" var="m"> 
              <option value="${m.shippingcost}">${m.shipingchargeviastate}</option>
             </c:forEach>
           </select>
         </td>
       </tr> 
       
       <tr>
         <td><strong>Total w/ Shipping</strong></td>
         <td><div id='ftot'>$ <%=totalprice%></div></td>
       </tr>  
       
     </tbody>
 	</table>
 	
 	<h1>Shipping Details</h1>
 	 <table>
               <tbody> 
          <c:forEach items="${shippingdetails}" var="m">                              
               <tr>
                <td ><strong>Name:&nbsp;</strong></td>
                <td >${m.ship_fname} ${m.ship_mname} ${m.ship_lname}</td>                
                <td ><strong>Company:</strong></td>
                <td >${m.ship_company}</td>            
               </tr> 
               
               <tr >
                 <td ><strong>Address:</strong></td>
                  <td >${m.ship_address}</td>
                  <td ><strong>City:</strong></td>
                  <td >${m.ship_city}</td>
               </tr>
               
               
               <tr >
                  <td ><strong>State:</strong></td>
                  <td >${m.ship_state}</td>
                   <td ><strong>Zip/Postal Code:</strong></td>
                  <td >${m.ship_zipcode}</td>
               </tr>
 

               <tr >
                  <td ><strong>Country:</strong></td>
                  <td >${m.ship_country}</td>
                  <td ><strong>Phone:</strong></td>
                  <td >${m.ship_phone}</td>
               </tr>

               
               <tr >
                  <td ><strong>Email:</strong></td>
                  <td >${m.ship_email}</td>
                   <td ><strong>Fax:</strong></td>
                  <td >${m.ship_fax}</td>
               </tr>
               
            </c:forEach>
       </tbody></table>
 	
 	
 	
 </div>
 
 <div class="continuepayment">
                           
								<div class="Customer-Login">
									<table>
										<tbody>
										<tr>	
										     										 
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
										</tr> 
										 
										 
 
    
										 
     
										 
									</tbody></table>
									
		
		
		 <form action="makepayments" method="post">
		  <table>
		   <tr>
		      <td>
		         <td><input type="Submit" value="Submit"/></td> 
		      
		   </tr>
		  
		  </table>
		 
		 
		 </form>
									
	<!-- <form name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
     <table>
      <input type="hidden" name="cmd" value="_xclick" /> 
        <input type="hidden" name="business" value="basanttamagna@gmail.com" />  
       <input type="hidden" name="password" value="subhash7840" /> 
        <input type="hidden" name="custom" value="1123" />  
        <input type="hidden" name="item_name" value="Bicycle " />  
        <input type="hidden" name="amount" value="60.00"/>  
        <input type="hidden" name="rm" value="1" />  
        <input type="hidden" name="return" value="http://localhost:8080/PaypalGS/paypalResponse.jsp" />  
        <input type="hidden" name="amount" value="60.00"/>  
        <input type="hidden" name="cancel_return" value="http://localhost:8080/PaypalGS/paypalResponseCancel.jsp" />  
        <input type="text" name="cert_id" value="API Singature" />  
      <tr>
       <td>&nbsp;</td>
       <td><input type="Submit" value="Pay with Paypal"/></td>
     </tr>
   </table>
  </form>	-->
								</div>
							 
 </div>
					


					<div class="clear"></div>


				</div>
				</div>

				<div class="clear"></div>
				 <div class="clear"></div>
				 
			</div>
		 
 </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
