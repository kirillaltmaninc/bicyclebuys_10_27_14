
 <jsp:include page="header3.jsp"></jsp:include> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% adminDAO obj;obj=new adminDAOImpl();%>
  <script type="text/javascript" src="js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
	<script>
			$(document).ready(function() {
				$('.accordion:eq(0)> div').hide();
	        	$('.accordion:eq(0)> h3').click(function() {
	        	    $(this).next().slideToggle('fast');
	        	    $(this).toggleClass('active');
	        	});
        	});
		</script> 
		<%String rvalue=(String)request.getAttribute("radiostatus"); %> 
		 <script type="text/javascript">
		$(document).ready(function() {
		$( "#chkSelect").prop('<%=rvalue%>', true);
		
		});
	</script>
<script language="javascript">

window.onload=toggle();
function toggle() {
	
	var isChecked = $("#chkSelect").prop('checked');
	<%String val="";%>
	if(isChecked || typeof isChecked=="undefined")
	{  
		$("#d1").slideDown();
		$("#d2").slideUp();
		$("#scval").html("notok");
		//var script = document.createElement( "script" );
		//script.type = "text/javascript";
		//script.src = "script.src = "checkout.js";";
		//document.body.appendChild(script); 
	}
	else  
	{ 	 
		$("#d2").slideDown();
		$("#d1").slideUp();
		$("#scval").html("ok");
		//var str="<script src='checkout.js'>";
		//str+="<";
		//str+="/script>";
		//var script = document.createElement( "script" );
		//script.type = "text/javascript";
		//script.src = "checkout.js";
		//document.body.appendChild(script);
		
	}
	
  
}
</script>
<body> 
</div> 
<!-- Main jumbotron for a primary marketing message or call to action --> 
<div style="clear:both;"></div>
 <div class="container"> 
    <div style="clear:both;"></div>
 	    <div class="col-md-3">
     <div class="payment1">
        
        <%@ page import="java.text.*" %> 
		 
        
     
     <h1>1.Shipping details</h1>
        <div class="inners">
        
        <div class="adres">
        	<strong>SHIPPING ADDRESS</strong>
        	<c:forEach items="${shippingdetails}" var="m"> 
            <p>${m.ship_fname} ${m.ship_mname} ${m.ship_lname}</p>
            <ul > 
              <li >${m.ship_address}</li>
              <li>${m.ship_city}</li>
              <li>${m.ship_state}</li>
              <li >${m.ship_zipcode}</li>
              
              <li>${m.ship_email}</li>
            </ul>
            </c:forEach>
        </div>
        <div class="adres">
        	<strong>SHIPPING TYPE</strong>
        	 
            <p>${sessionScope.shipMethod}</p>
             
             
        </div>
     
       
       
    <div class="clr"></div>
    
    <div class="clr1"></div>
        </div>
        
        
         
        
        
        
        <h1>2. PAYMENT</h1>
        
        
        <form action="makepayments1" method="post" name="checkoutform" id="checkoutform">
        
         <div class="inners">   
         
         <%if(request.getAttribute("errormessage")==null) {%> <%} else{ %>
         <b><font color="red"><%=request.getAttribute("errormessage") %></font></b> 
              <%} %>
        <strong> PAYMENT TYPE</strong>
        <img src="images/icon.jpg" class="icons" />
        <img src="images/icon1.jpg" class="icons" />
        <img src="images/icon2.jpg" class="icons" />
        <img src="images/icon3.jpg" class="icons" />
        <div class="clr"></div>
        <%String paymenmode=""; 
        String frm="";
        %>
        
        <script type="text/javascript">
        function showDiv(elem)
         {
        	//window.alert(cardtype.value);
        	   if(elem.value == 2)
        	   {
        		  
        	      document.getElementById('hidden_div').style.display = "block";
        	      document.getElementById('hidden_div1').style.display = "none";
        	      
        	      
        	      
        	      
        	      document.getElementById("first-name-field").disabled = true;
   			   document.getElementById("card-exp-month").disabled = true;
   			   document.getElementById("card-exp-year").disabled = true;
   			   document.getElementById("first-name-field4").disabled = true;
   			 document.getElementById("first-name-field").style.backgroundColor = "#E1E1E1";
			   document.getElementById("card-exp-month").style.backgroundColor = "#E1E1E1";
			   document.getElementById("card-exp-year").style.backgroundColor = "#E1E1E1";
			   document.getElementById("first-name-field4").style.backgroundColor = "#E1E1E1";
   			   
        	   }
        	   if(elem.value == 1 || elem.value == 3)
        	   {   
        		  if(elem.value == 1)
        			  {
        			  document.getElementById("first-name-field").disabled = false;
       			      document.getElementById("card-exp-month").disabled = false;
       			      document.getElementById("card-exp-year").disabled = false;
       			      document.getElementById("first-name-field4").disabled = false;
       			      document.getElementById("first-name-field").style.backgroundColor = "white";
  			          document.getElementById("card-exp-month").style.backgroundColor = "white";
  			   		  document.getElementById("card-exp-year").style.backgroundColor = "white";
  			          document.getElementById("first-name-field4").style.backgroundColor = "white";
        			   paymenmode="CreditCart";
        			  }
        		  else
        			  {
        			   document.getElementById("first-name-field").disabled = true;
        			   document.getElementById("card-exp-month").disabled = true;
        			   document.getElementById("card-exp-year").disabled = true;
        			   document.getElementById("first-name-field4").disabled = true;
        			   document.getElementById("first-name-field").style.backgroundColor = "#E1E1E1";
        			   document.getElementById("card-exp-month").style.backgroundColor = "#E1E1E1";
        			   document.getElementById("card-exp-year").style.backgroundColor = "#E1E1E1";
        			   document.getElementById("first-name-field4").style.backgroundColor = "#E1E1E1";
        			   paymenmode="Fax";
        			  }
        		  
        	      document.getElementById('hidden_div').style.display = "none";
        	      document.getElementById('hidden_div1').style.display = "block";
        	   }
         }        
        </script>
        
        <table width="100%" border="0">
        <tbody>
        <tr>
            <td class="tablewidth">
				Card type
			</td>
		     <td class="tablewidth1"> 
		     <select id="cardtype" name="cardBrand" class="country" onchange="showDiv(this)"> 
								<option value="1" data-paymentcode="001">Credit Cart</option>							
								<option value="2" data-paymentcode="002">PayPal</option>							
								<option value="3" data-paymentcode="003">Fax/Call Order In</option>					 
							
					</select></td>
		     <td class="tablewidth2">&nbsp;</td>
		     
  		</tr>
  <tr>
    <td>
				Card number
			</td>
    <td><input id="first-name-field" name="cardno" class="country" value="" maxlength="50" >
    <span id="cardnumInfo"> </span>  </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
				Expires
			</td>
     <td> <select id="card-exp-month" name="cardExpiryMonth" class="country2">
				    <option value="" data-property="GLB_MONTH">Month</option>				
					<option class="tealeaf-pci" value="01">01</option>				
					<option class="tealeaf-pci" value="02">02</option>				
					<option class="tealeaf-pci" value="03">03</option>				
					<option class="tealeaf-pci" value="04">04</option>				
					<option class="tealeaf-pci" value="05">05</option>				
					<option class="tealeaf-pci" value="06">06</option>				
					<option class="tealeaf-pci" value="07">07</option>				
					<option class="tealeaf-pci" value="08">08</option>				
					<option class="tealeaf-pci" value="09">09</option>				
					<option class="tealeaf-pci" value="10">10</option>				
					<option class="tealeaf-pci" value="11">11</option>				
					<option class="tealeaf-pci" value="12">12</option>				
			</select>
            
            <select id="card-exp-year" name="cardExpiryYear"  class="country2">
				<option value="" data-property="GLB_YEAR">Year</option>				
					<option class="tealeaf-pci" value="2014">2014</option>				
					<option class="tealeaf-pci" value="2015">2015</option>				
					<option class="tealeaf-pci" value="2016">2016</option>				
					<option class="tealeaf-pci" value="2017">2017</option>				
					<option class="tealeaf-pci" value="2018">2018</option>				
					<option class="tealeaf-pci" value="2019">2019</option>				
					<option class="tealeaf-pci" value="2020">2020</option>				
					<option class="tealeaf-pci" value="2021">2021</option>				
					<option class="tealeaf-pci" value="2022">2022</option>				
					<option class="tealeaf-pci" value="2023">2023</option>				
			</select>
			<span id="cardexpInfo"></span>
			</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
				CVV Code
			</td>
    <td><input id="first-name-field4" name="first-name-field3" class="country"  maxlength="50" >
    <span id="firstnamefield4Info"></span>
    </td>
    <td>&nbsp;</td>
  </tr>
  </tbody>
  </table> 
        
<div class="clr1"></div>



 

<link rel="stylesheet" href="general1.css" />



  <p style="font-weight: bold;"> <input type="checkbox" id="chkSelect"   name="chkselect"   onClick="toggle();" /> Use my shipping address  </p> 
   
  <div id="d1" style="display:<%=request.getAttribute("fdiv")%>;">
  
<div class="adres">
        	<strong>SHIPPING ADDRESS  </strong>
        	<c:forEach items="${shippingdetails}" var="m"> 
            <p>${m.ship_fname} ${m.ship_mname} ${m.ship_lname}</p>
            <ul >
               
              <li >${m.ship_address}</li>
              <li>${m.ship_city}</li>
              <li>${m.ship_state}</li>
              <li >${m.ship_zipcode}</li>
              
              <li>${m.ship_email}</li>
              
              <c:set var="email" value="${m.ship_email}"></c:set>
            </ul>
            <input type="hidden" name="email" value="${m.ship_email}"> 
            </c:forEach>
            
            
            
            <input type="hidden" name="taxrate" value="<%=session.getAttribute("taxrate")%>">
            <c:forEach items="${shippingdetails}" var="m"> 
          	<input type="hidden" name="useremail" >
          </c:forEach>
        </div> 
 
 <input type="hidden" name="shipVIA" value="${sessionScope.shipMethod}">
</div> 
 
   

 
<div id="d2" style="display:<%=request.getAttribute("sdiv")%>;"> 
<jsp:useBean id="shipdetailDTO" class="com.admin.action.userDTO" scope="request"></jsp:useBean>
<center>
<c:if test="${requestScope.shiperror ne null}">
<font color="red"><c:out value="${requestScope.shiperror}"></c:out></font>
</c:if>
</center>

<table width="100%" border="0">
  <tbody>
  <tr>
     <td class="tablewidth">			
			First Name<font color="red"><b>*</b></font>
     </td>
    <td class="tablewidth1"><input   name="fname" class="country"  maxlength="50" autofocus="" id="fname"></td>
    <td><span id="fnameInfo"></span></td>
  </tr>
  <tr>
    <td>  Last Name <font color="red"><b>*</b></font></td>
    <td>  
          <input   name="lname" class="country"  maxlength="50" autofocus="" id="lname">
          <c:forEach items="${shippingdetails}" var="m"> 
          	<input type="hidden" name="useremail" >
          </c:forEach>
          <input type="hidden" name="taxrate" value="<%=session.getAttribute("taxrate")%>">
          
            </td>
    <td><span id="lnameInfo"></span></td>
  </tr>
  
  
  <tr>
    <td>
				Address <font color="red"><b>*</b></font>
			</td>
    <td><input   name="address" class="country"  maxlength="50" autofocus="autofocus" id="address"></td>
    <td><span id="addressinfo"></span></td>
  </tr>
  <tr>
    <td>City <font color="red"><b>*</b></font></td>
    <td><input   name="city" class="country"  maxlength="50" autofocus="autofocus" id="city"></td>
    <td><span id="cityinfo"></span></td>
  </tr>
  
  <tr><td>State:<font class="red">*</font></td>
												<td><select name="STATEPROVINCE" onChange="ChkSP();"
													class="country" id="country">

														<option value="ZZ">Choose state/Province</option>
														<% 
					ArrayList getallstate1=(ArrayList)request.getAttribute("getallstate");
					if(!getallstate1.isEmpty())
                        {  	
                        for(int i=0;i<getallstate1.size();i++)
                         { 
                        	userDTO e=(userDTO)getallstate1.get(i); 
                          %>
														<option value="<%=e.getState() %>"><%=e.getState() %></option>
														<%}} %>
												</select>
                                  <span id="countryinfo"></span>

													<div class="clear"></div>
													<p class="Canada">US and Canada Only!</p></td>
													<td><div class="WE-SHIP">
													
													</div>
													</td>
													</tr>
  
  
  
  <tr>
 
												<td>Country</td>
												<td><select name="COUNTRY" class="country" id="shipcountry"
													onchange="chk1();">

														<option value="">Choose country</option>
														<% 
					ArrayList getcountry=(ArrayList)request.getAttribute("getcountry");
					if(!getcountry.isEmpty())
                        {  	
                        for(int i=0;i<getcountry.size();i++)
                         { 
                        	userDTO e=(userDTO)getcountry.get(i); 
                          %>
														<option value="<%=e.getCountry() %>"><%=e.getCountry() %></option>
														<%} }%>
												</select></td>
												  <td><span id="shipcountryi"></span></td>
                                                </tr>
  
  
  <tr>
    <td>Postal Code <font color="red"><b>*</b></font></td>
    <td><input   name="postalcode" class="country"    autofocus="autofocus" id="postalcode" maxlength="5"></td>
    <td><span id="postalcodeinfo"></span></td>
  </tr> 
     </tbody></table>



</div>
  <div class="clr"></div>
  <div id='hidden_div1' style="display:block;"> 
	<table>
	<tr>
	<input type="hidden" name="shipcost" value="<%=request.getAttribute("radiovalue")%>">
     
    <td><input type="Submit" class="buttond-blue" name="submit" value="Submit"/></td>
    <td>&nbsp;</td>
  </tr>
	</table>	  
     </div>     
  
 
 <div id='val'>
 
  
    </div>  
      
<div class="clr1"></div>

    <div class="orange">
    
     
   </div>
    <div class="clr1"></div>
       </div>
   </form>
    <script type="text/javascript" src="checkout.js"></script>	
   <div id="scval" style="display:none;">
   notok
   </div>
   
   
   <%
    
   String uid = (String)session.getAttribute("uid");
   String bookingcode = "";
   String cookieName = "BICYCLE";
   Cookie[] cookies = request.getCookies();
   if (cookies != null) {
     for (int i = 0; i < cookies.length; i++) {
       if (cookies[i].getName().equals(cookieName))
       {
          
         bookingcode = cookies[i].getValue();
         
       }
     }
   }
   ArrayList carddetails1 =obj.getcartdetails(bookingcode, uid); 
   
   double rebettotal1=0;
   double ptotal=0;
   double frebet=0;
   if(!carddetails1.isEmpty())
   {  	
   for(int i=0;i<carddetails1.size();i++)
    {  
	   productDTO e=(productDTO)carddetails1.get(i);  
		   if(e.getWebnoteid().equals("15") && (e.getPrice()>e.getRebateprice()))
	       {
	    	   System.out.println("INSIDE ZUBAIR.JSP->"+e.getRebateprice());
	    	   System.out.println(e.getRebateprice());    	   
	    	   rebettotal1=rebettotal1+(e.getRebateprice()* e.getQty());   
	    	   ptotal=ptotal+(e.getPrice() * e.getQty());
	    	   
	       } 
	    
    }
   System.out.println("ptotal++++++-->"+ptotal);
   System.out.println("ptotal++++++-->"+rebettotal1);
   frebet=ptotal-rebettotal1;
   }
   
   %>
   
   	<c:set var="frc" value="<%=frebet %>"></c:set> 
    <c:set var="sc" value="${sessionScope.shipCost}"></c:set>
    <c:set var="txr" value="${sessionScope.taxrate}"></c:set>
    <c:set var="cp" value="${sessionScope.couponprice}"></c:set>
    <c:set var="afterDiscount" value="${ft-cp}"></c:set>
    <c:set var="taxAmt" value="${afterDiscount*txr/100}"></c:set>
   <div class="inners">
   <div id='hidden_div' style="display:none;"> 
         <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
         
				<input type="hidden" name="cmd" value="_cart">
				<input type="hidden" name="upload" value="1">
				<input type="hidden" name="business" value="basanttamagna@gmail.com">
				<input type="hidden" name="password" value="subhash7840" /> 
				<input type="hidden" name="currency_code" value="US">
				 <% int j=1;int k=500;
					ArrayList getallstate=(ArrayList)request.getAttribute("carddetails"); 
                        for(int i=0;i<getallstate.size();i++,j++)
                         {
                        	System.out.println("VALUE--->"+i);
                        	productDTO e=(productDTO)getallstate.get(i); 
                          %>  
					<input type="hidden" name="item_name_<%=j%>" value="<%=e.getProduct_name()%>">
					<input type="hidden" name="amount_<%=j%>" value="<%=e.getPrice()%>">  
					<input type="hidden" name="quantity_<%=j%>" value="<%=e.getQty()%>" /> 
					<input type="hidden" name="tax_rate_<%=j%>" value="${txr}">
				   <%if(i==getallstate.size()-1) { 
				       System.out.println("IN SIDE PAYPAL IF");
				   %>	
				   
                 <input type="hidden" name="shipping_<%=j%>" value="${sessionScope.shipCost}">
	             <input type="hidden" name="discount_amount_<%=j%>" value="${sessionScope.couponprice+frc}">
	                <%}%> 
				 <%} %> 
				<input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but01.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!">
          </form>
     </div>
   </div>
   
          
   
   
   
   
   
       
     </div>
     </div>
     
    <div class="col-md-2">
      <div class="summey">
      	<strong>SUMMARY</strong>
        <table width="100%" border="0">
  <tbody>
  	
  	
  
  <% ArrayList cardde =obj.getcartdetails1(bookingcode, uid); 
   
   double rebettotal=0;
   double finaltotal=0;
   if(!cardde.isEmpty())
   {  	
   for(int i=0;i<cardde.size();i++)
    {	   
	   productDTO e=(productDTO)cardde.get(i); 
	   
       finaltotal=finaltotal+(e.getPrice()*e.getQty());   
       
    }
   }
   
   %>
   
  	
   <tr>
    <td>MERCHANDISE TOTAL</td>
    <td><fmt:formatNumber  value="<%=finaltotal%>" type="currency"></fmt:formatNumber></td>
   </tr>
   <%session.setAttribute("finaltotal", finaltotal); %> 
   
   
    <c:if test="${not empty sessionScope.shipCost and requestScope.radiovalue eq 'null'}">
   <tr>
    <td>SHIPPING COST</td>
    <td>International Shipping</td>
   </tr> 
   </c:if>
   
    <c:if test="${not empty sessionScope.shipCost and requestScope.radiovalue  !=  'null'}">
   <tr>
    <td>SHIPPING COST</td>
    <td><fmt:formatNumber  value="${sessionScope.shipCost}" type="currency"></fmt:formatNumber></td>
   </tr> 
   </c:if>
   
   <tr>
    <td>TAX AMOUNT</td> 
    <td><fmt:formatNumber  value="${taxAmt}" type="currency"></fmt:formatNumber></td>
   </tr>
   
   <c:set var="txtamt" value="${taxAmt}" /> 
   <%double txtamt = (Double)pageContext.getAttribute("txtamt");
   session.setAttribute("txtamt",txtamt);
   %>
   
   
   <%
   double d=(Double)session.getAttribute("couponprice");
    
   if(d==0.0) {%>
  
   <%} else { %>
     
   <tr>
    <td>COUPON PRICE</td> 
    <td><fmt:formatNumber  value="${sessionScope.couponprice}" type="currency"></fmt:formatNumber></td>
   </tr>
     
   <%} %>
   
   
   
   
   
   <%if(rebettotal1==0) {%><%}else{ %>
   <tr>
    <td>Rebate Total</td> 
    <td><fmt:formatNumber value="<%=frebet%>" type="currency"></fmt:formatNumber></td>
   </tr>
   <%} %>
   <c:set var="rp" value="<%=frebet%>"></c:set>
   <c:set var="frt" value="<%=frebet%>"></c:set>
   <%double reprice = (Double)pageContext.getAttribute("rp");
      session.setAttribute("reprice",reprice);
    %>
   
   
   
    <c:set var="ototal" value="${ft+sc+taxAmt-cp-ftr}" /> 
    <%double ototal = (Double)pageContext.getAttribute("ototal");
      session.setAttribute("ototal",ototal);
    %>
   
   
   <c:set var="ft" value="<%=finaltotal%>"></c:set>
   
   <tr>
    <td>ORDER TOTAL </td> 
    <td><fmt:formatNumber value="${ft+sc+taxAmt-cp-frt}" type="currency"></fmt:formatNumber></td>
   </tr>
   
   
   
   </tbody>
   </table>
 
 
 
 <div class="clerar-bottom"></div>
 
  <div class="accordion">
			
			
			
	<c:forEach items="${carddetails}" var="c">
			<h3> 
			
			<c:if test="${fn:length(c.product_name)>30}">
				<c:set var="string2" value="${fn:substring(c.product_name, 0, 28)}" />
				${string2} ...
				</c:if>
				<c:if test="${fn:length(c.product_name)<=30}">
				${c.product_name}
			</c:if> 
			
			</h3>
			<div>
			 <table width="100%" border="0" class="table-price">
  <tbody><tr>
     <td width="41%" rowspan="4"><img src="productimages/${c.picturename}" class="bag"></td>
     <td width="18%"><p>Qty</p> </td>
     <td width="41%"><p>${c.qty}</p></td>
    </tr>
  <tr>
    <td><p>Price</p></td>
    <td><p>${c.price}</p></td>
  </tr>
   
   <tr>
    <td><p>SKU</p></td>
    <td><p>${c.SKU}</p></td>
  </tr>
  
   
             </tbody></table>

			</div>
	 </c:forEach>
		</div>
		
		 
      </div>
   </div>
       
     
</div>
 
 
 
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
 
