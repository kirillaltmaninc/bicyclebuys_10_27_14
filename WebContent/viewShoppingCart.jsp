<jsp:include page="header1.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<!DOCTYPE html>
<html lang="en">
 <link rel="stylesheet" type="text/css" href="css/table-new.css"/>
<body> 
  <div class="container">
 
 	 <div class="test">
  <div class="add-to-cart">
    		<h1> 
    		1 888 4 Bike Buy Free Shipping $99 on Order Over
    		</h1>
           <div class="clear"></div>
            <div class="clear"></div>
             <div class="table-new">
             	<div class="table-iiner">
             	
             	
             	
             	              <font color="red">
              
              <%if(request.getAttribute("error")==null){ %>

<%} else { %>

  
       <%=request.getAttribute("error") %> 
       
<%} %>
              
              
               </font>






<%session.removeAttribute("coupanprice");session.removeAttribute("finaltotalprice");session.removeAttribute("totalprice"); %>
                <strong><a href="clearcartdetails">Clear All</a></strong>
                
                	<%@ page import="java.text.*" %> 
							<%float totalval=0,totalval1=0;  
							DecimalFormat twoDForm = new DecimalFormat("#0.00");
							%>
							 <%@ page import="com.admin.action.*" %>
		 	 <%@ page import="java.util.*" %>
					<% 
					ArrayList newproduct1=(ArrayList)request.getAttribute("carddetails");
					if(!newproduct1.isEmpty())
                        {
                     	int j=1; 
                        for(int i=0;i<newproduct1.size();i++)
                        { 
                        	productDTO e=(productDTO)newproduct1.get(i); 
                        %>  
                      <script type="text/javascript"> 
                         function updatecart<%=i%>() 
	                      {	  
		                      document.updatecartafterselect<%=i%>.submit();
	                      } 
                        </script>
                        	<form name="updatecartafterselect<%=i%>" action="updatecart" method="post" >
                	<table  border="1" width="100%">
  <tr>
    <td width="20%" class="bg"><strong>Qty.</strong></td>
    <td><input type="text" class="Qty" size="5"  name="qtyforupdate" value="<%=e.getQty() %>" id="select"></td>
 </tr>
 
 
 
   <tr>
    <td class="bg"><strong>Item #</strong></td>
    <td> <span><%=e.getSKU() %></span> <input type="hidden" name="cartID" value="<%=e.getCartID()%>"></td>
  </tr>
  
  
  
   <tr>
    <td  class="bg"><strong>Description</strong></td>
  <td>  
 <a  href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getPid() %>&subid=<%=e.getSubcatid()%>">
							  <img src="productimages/<%=e.getPicturename() %>" alt=""  class="img1"> </a>
							   <p><a href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getPid() %>&subid=<%=e.getSubcatid()%>"><%=e.getProduct_name() %></a></p>
							  <p>
							  
							  <%if(e.getColorandsize().equals("") || e.getColorandsize()==null) {%> 
							    
							  <%} else { %>
							  You have selected :
							     <%=e.getColorandsize() %>  <br>  
							  <%} %>
							  
							  <%
        ArrayList colorandsize;
        colorandsize=obj.getcolorandsizedetails(String.valueOf(e.getPid()));
        if(!colorandsize.isEmpty())
        { %>
         <p><b><a href="#">    </a></b>  </p> 
       <select name ="colorandsizeid" class="dropdown" onchange="updatecart<%=i%>();"> 
        <%
        for(int i1=0;i1<colorandsize.size();i1++)
         { 
        	productDTO e1=(productDTO)colorandsize.get(i1);  
        	float chprice1 = (Float)e1.getPrice(); 
            float price1 = (Float)e.getPrice(); 
            String value="";
            float fprice=0.0f;
            if(chprice1<price1)
            {
               fprice= (chprice1-price1);
               value="-";
            }
            else
            {
         	   fprice=(chprice1-price1);
         	   value="+";
            }
            
          %>  
          <%if(price1==chprice1) {%>
          <%if(e.getColorandsize().equals(e1.getColorandsize()) && e.getChieldid()==e1.getId()) {
            	 %> 
              <option value="<%=e.getColorandsize() %><><%=e.getChieldid()%>" selected><%=e.getColorandsize() %> </option> 
             <%} else { %>
              <option value="<%=e1.getColorandsize() %><><%=e1.getId()%>"><%=e1.getColorandsize() %> </option> 
             <%} %>  
          
          <%} else {%>
          <%if(e.getColorandsize().equals(e1.getColorandsize()) && e.getChieldid()==e1.getId()) {
            	 %> 
              <option value="<%=e.getColorandsize() %><><%=e.getChieldid()%>" selected><%=e.getColorandsize() %><%=value %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber>   </option> 
             <%} else { %>
              <option value="<%=e1.getColorandsize() %><><%=e1.getId()%>"><%=e1.getColorandsize() %><%=value %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber></option> 
             <%} %>  
          
          <%} %>
             
        <%}%>
        </select>  
           <%} else {%>
           
           <div  >
           <br/>
            <p><b><a href="#">  </a></b>  </p> 
           </div>
           <%} %>                  
 </td>  
</tr>
  
  
  
<tr>
  <td class="bg"><strong>Unit Price</strong></td>
  <td  colspan="2"><span><fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format(e.getPrice()))%>" type="currency"></fmt:formatNumber>  </span></td>
</tr>
    
    
<tr>
  <td class="bg"><strong>Total Price</strong></td>
  <td  colspan="2"><span> <fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format((((e.getQty()) * (e.getPrice()))))) %>" type="currency"></fmt:formatNumber>   </span></td>
</tr>

<tr>
  <td class="bg"><strong>Action</strong></td>
  <td> 
  <div class="removed"><a href="deletecartitems?cid=<%=e.getCartID()%>&pid=<%=e.getPid()%>">Remove </a></div>
<input type="submit" class="removed1" value="Update">
   
  </td>
</tr>
  
</table>
</form>
  <%totalval= totalval+ (e.getQty()) * (e.getPrice()); }} %>
<table  border="0" width="100%">
	 <tr class="bg1">
    <td width="20%"  ><strong>Sub Total</strong></td>
    <td > <fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format(((totalval)))) %>" type="currency"></fmt:formatNumber> 
                              <%session.setAttribute("totalprice", String.valueOf(totalval));%>
                              
                              
                              </td>
    </tr>
</table>


                                <div class="orange1"><a href="checkoutcart">Proceed to Checkout »</a></div>
                                
                                <div class="orange"><a href="indexpage">Continue Shopping »</a></div>
                </div>
             </div>
              <div class="table-responsive">
            <div class="Courses1">
              <div id="msgerror"> 
             
              <font color="red">
              
              <%if(request.getAttribute("error")==null){ %>

<%} else { %>

  
       <%=request.getAttribute("error") %> 
       
<%} %>
              
              
               </font>






<%session.removeAttribute("coupanprice");session.removeAttribute("finaltotalprice");session.removeAttribute("totalprice"); %>
</div> <div class="clear"></div>
                 
                 
                        
                        
                   <table class="course">
							<tbody>
							<tr class="even">
							<td class="width"> <strong>Qty.</strong> </td>
							<td id="Item"> <strong>Item #</strong></td>
							<td colspan="2" id="Description"><strong>Description</strong></td>
							<td><strong>Unit Price</strong></td>
                            <td><strong>Total Price</strong></td>
                             <td><strong>Action</strong></td>
                              <td><strong><a href="clearcartdetails">Clear All</a></strong></td>
							</tr>
							 
                            <%@ page import="java.text.*" %> 
							<%  
							
							%>
							 <%@ page import="com.admin.action.*" %>
		 	 <%@ page import="java.util.*" %>
					<% 
					
					if(!newproduct1.isEmpty())
                        {
                     	int j=1; 
                        for(int i=0;i<newproduct1.size();i++)
                        { 
                        	productDTO e=(productDTO)newproduct1.get(i); 
                        %>  
                      <script type="text/javascript"> 
                         function updatecart<%=i%>() 
	                      {	  
		                      document.updatecartafterselect<%=i%>.submit();
	                      } 
                        </script>
							<form name="updatecartafterselect<%=i%>" action="updatecart" method="post" >
							<tr>
							  <td class="width"><input type="text" class="Qty" size="5"  name="qtyforupdate" value="<%=e.getQty() %>" id="select"></td>
							  <td><span><%=e.getSKU() %></span>
							  <input type="hidden" name="cartID" value="<%=e.getCartID()%>">							  </td>
							  <td colspan="1" >
							  <a  href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getPid() %>&subid=<%=e.getSubcatid()%>">
							  <img src="productimages/<%=e.getPicturename() %>" alt=""  class="img1"> </a> </td> 
							  <td > 
							  <p><a href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getPid() %>&subid=<%=e.getSubcatid()%>"><%=e.getProduct_name() %></a></p>
							  <p>
							  
							  <%if(e.getColorandsize().equals("") || e.getColorandsize()==null) {%> 
							    
							  <%} else { %>
							  You have selected :
							     <%=e.getColorandsize() %>  <br>  
							  <%} %>
							  
							  <%
        ArrayList colorandsize;
        colorandsize=obj.getcolorandsizedetails(String.valueOf(e.getPid()));
        if(!colorandsize.isEmpty())
        { %>
         <p><b><a href="#">    </a></b>  </p> 
       <select name ="colorandsizeid" class="dropdown" onchange="updatecart<%=i%>();"> 
        <%
        for(int i1=0;i1<colorandsize.size();i1++)
         { 
        	productDTO e1=(productDTO)colorandsize.get(i1);  
        	float chprice1 = (Float)e1.getPrice(); 
            float price1 = (Float)e.getPrice(); 
            String value="";
            float fprice=0.0f;
            if(chprice1<price1)
            {
               fprice= (chprice1-price1);
               value="-";
            }
            else
            {
         	   fprice=(chprice1-price1);
         	   value="+";
            }
            
          %>  
          <%if(price1==chprice1) {%>
          <%if(e.getColorandsize().equals(e1.getColorandsize()) && e.getChieldid()==e1.getId()) {
            	 %> 
              <option value="<%=e.getColorandsize() %><><%=e.getChieldid()%>" selected><%=e.getColorandsize() %> </option> 
             <%} else { %>
              <option value="<%=e1.getColorandsize() %><><%=e1.getId()%>"><%=e1.getColorandsize() %> </option> 
             <%} %>  
          
          <%} else {%>
          <%if(e.getColorandsize().equals(e1.getColorandsize()) && e.getChieldid()==e1.getId()) {
            	 %> 
              <option value="<%=e.getColorandsize() %><><%=e.getChieldid()%>" selected><%=e.getColorandsize() %><%=value %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber>   </option> 
             <%} else { %>
              <option value="<%=e1.getColorandsize() %><><%=e1.getId()%>"><%=e1.getColorandsize() %><%=value %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber></option> 
             <%} %>  
          
          <%} %>
             
        <%}%>
        </select>  
           <%} else {%>
           
           <div  >
           <br/>
            <p><b><a href="#">  </a></b>  </p> 
           </div>
           <%} %>                  </td>
							  </p>
							  <td id="Item"><span><fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format(e.getPrice()))%>" type="currency"></fmt:formatNumber>  </span></td>  
							  <td id="Item"><span> <fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format((((e.getQty()) * (e.getPrice()))))) %>" type="currency"></fmt:formatNumber>   </span>
							  <td id="Item" valign="center"><div class="removed"><a href="deletecartitems?cid=<%=e.getCartID()%>&pid=<%=e.getPid()%>">Remove </a></div></td>
							  <td id="Item" valign="center"> <input type="submit" class="removed1" value="Update"></td>
							  </tr>  
							  </form>
							  <%totalval1= totalval1+ (e.getQty()) * (e.getPrice()); }} %>
					
	 			   <tr class="border">
							  <td colspan="4"  ><div> 
       

       <label>  <div class="Code">  </div>
       <div class="Code1">  </div>

    </label> 
                            </div></td>
							                         
							  <td>&nbsp;</td>
							  <td>&nbsp;</td>
							  <td colspan="3"> <strong class="red"> Sub Total</strong>&nbsp;&nbsp; 
							  <fmt:formatNumber  value="<%=Double.parseDouble(twoDForm.format(((totalval1)))) %>" type="currency"></fmt:formatNumber> 
                              <%session.setAttribute("totalprice", String.valueOf(totalval1));%>  
                             </td>
				   </tr> 
							 
							 
							 
							</tbody>
							</table> 
                           
                           	   
             
                                <div class="orange1"><a href="checkoutcart">Proceed to Checkout »</a></div>
                                
                                <div class="orange"><a href="indexpage">Continue Shopping »</a></div>
                                
           </div>
             </div>
   
</div>
 </div>
 </div>
		<jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>
