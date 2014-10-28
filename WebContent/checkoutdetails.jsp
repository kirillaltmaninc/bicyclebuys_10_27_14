<jsp:include page="header1.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="general1.css" />

<script type="text/javascript" src="js/ajax.js"></script>
 <script>
$(document).ready(function(){
 $("#signin").click(function(){
   $("#show").slideToggle();
$("#show1").slideUp();
 });
});


$(document).ready(function(){
$("#cancel").click(function(){
$("#show").slideUp();
});
});

$(document).ready(function(){
$("#signin1").click(function(){
$("#show1").slideToggle();
$("#show").slideUp();
});
});


$(document).ready(function(){
$("#signin2").click(function(){
$("#show1").slideUp();
});
});

</script>
 

<script type="text/javascript">
function ChkSP()
{
if (document.checkoutform.STATEPROVINCE.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform.COUNTRY.value != "US")
{
document.checkoutform.COUNTRY.value = "US";
document.checkoutform.CUSTOM1.disabled=true;
document.checkoutform.CUSTOM1.value = 'for International';
}
}
} //end of function

function chk1()
{
if (document.checkoutform.STATEPROVINCE.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform.COUNTRY.value != "US")
{
document.checkoutform.STATEPROVINCE.value = "ZZ"; 
}
}
}
</script>


<script type="text/javascript">
function ChkSP1()
{
if (document.checkoutform1.STATEPROVINCE1.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform1.COUNTRY1.value != "US")
{
document.checkoutform1.COUNTRY1.value = "US";
document.checkoutform1.CUSTOM1.disabled=true;
document.checkoutform1.CUSTOM1.value = 'for International';
}
}
} //end of function

function chk11()
{
if (document.checkoutform1.STATEPROVINCE1.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform1.COUNTRY1.value != "US")
{
document.checkoutform1.STATEPROVINCE1.value = "ZZ"; 
}
}
}
</script>

<script type="text/javascript">
function ChkSP2()
{
if (document.checkoutform2.STATEPROVINCE2.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform2.COUNTRY2.value != "US")
{
document.checkoutform2.COUNTRY2.value = "US";
document.checkoutform2.CUSTOM2.disabled=true;
document.checkoutform2.CUSTOM2.value = 'for International';
}
}
} //end of function

function chk111()
{
if (document.checkoutform2.STATEPROVINCE2.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform2.COUNTRY2.value != "US")
{
document.checkoutform2.STATEPROVINCE2.value = "ZZ"; 
}
}
}
</script>



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

 
<%@ page import="java.text.*" %> 
	<%double totalval=0;  
	DecimalFormat twoDForm = new DecimalFormat("#0.00");							 
    double totalpricevalue= (Double)(session.getAttribute("finaltot"));  
  %>
  
   
  
  
  <script type='text/javascript'>//<![CDATA[ 

window.addEventListener("load", function () {
    var couponcodes = document.getElementsByClassName("couponcode");
    for (var i = 0; i < couponcodes.length; i++) {
        couponcodes[i].addEventListener("mouseover", function () {
            var coupontooltip = this.getElementsByClassName("coupontooltip")[0];
            coupontooltip.removeAttribute("style");
        });
        couponcodes[i].addEventListener("mouseout", function () {
            var coupontooltip = this.getElementsByClassName("coupontooltip")[0];
            coupontooltip.style.display = "none";
        });
    }
});
//]]>  

</script>
  
  
  <%String statename=(String)request.getAttribute("statename"); %>
  
<body onload="get1('<%=statename%>','<%=totalpricevalue%>'); getcalculate('<%=request.getAttribute("shipCost")%>','<%=totalpricevalue%>',<%=session.getAttribute("couponprice")%>);">  

	 <div class="container">
 
   
   
   
   
   <%if(session.getAttribute("email")==null) { %>
   
   <div class="login-user">
    	<div class="user-name">
        

<!--<div class="shows" id="signin1"><a href="#">Join</a></div>-->

 <div class="shows" id="signin"><a href="javascript:void(0)">SIGN IN  </a></div> 
 
</div>



<div class="clr"></div>





<form action="login1" method="post">
					<div id="show" style="display: <%=request.getAttribute("divdisplay")%>;">
 					 
					 
					 <div class="login-contact">
					 	
					 	<table>
					 	  <tr>
					 	  <td>
					 	  <font color="red">
					<%
					ArrayList e5 = (ArrayList) request.getAttribute("errorlist");
					%>
					<%
					if (e5 != null) {
					Iterator it = e5.iterator();
					while (it.hasNext()) {
					%>
					<%
					out.println(it.next());
					%>
					<br>
					<%
					}
					}
					%></font>
					 	  </td>
					 	  </tr>
					 	</table>
					 	
					 	<ul>
					    	<li><strong>Email Address</strong>
					        	<input id="first-name-field" name="email" class="country" value="" maxlength="50" autofocus="">
					        </li>
					        <li><strong>Password</strong>
					        	<input id="first-name-field" type="password" name="pwd" class="country" value="" maxlength="50" autofocus="">
					        </li>
					         <li><strong> </strong> 
					        </li>
					        
					    </ul>
					    
					 </div>
					 <div class="clr"></div>
					<div class="inner-sign">
						 
						<input type="submit" value="Log in" class="signup1"> 
					
					<a href="#" id="cancel">cancel</a>
					</div>

			</div>
</form>




<div class="clr"></div>
<div id="show1" style="display: none;"> 
 <!-- <button id="signin2">Hide</button> --> 
</div>	
    </div>
   
   <%} else { %>
   
   
   <%} %>
   
    
    <div style="clear:both;"></div>
 	    <div class="col-md-3">
     <div class="payment1">
     
     	<h1>Shipping details</h1>
     		
     	<%-- <%if(request.getAttribute("error")!=null){ %>
                              <font color="red"> <%=request.getAttribute("error") %></font>
                               <%} %> --%>
        <div class="inners">  
                      
                      		<% 
                      		ArrayList userdetails=(ArrayList)request.getAttribute("userdetails");
						     if(userdetails==null || userdetails.isEmpty()) 
						     {%> 
								 
								 <%@page import="com.admin.action.*"%>
									<%  
										userDTO rBean = (userDTO) request.getAttribute("bean");
    									%>
        									<%
											if (request.getAttribute("errorlistforguest") == null) {
											%> 
												 
								 <form action="guestregisteruser1" method="post" name="checkoutform" id="customForm2"> 
                                  <table>
						                  <tr>
												<td class="tablewidth">First Name:<font class="red">*</font></td>
												<td class="tablewidth1">
												<input type="text" class="country" name="fname" id="fname" />
												 </td>
												 <td class="tablewidth2">
												 <span id="fnameInfo"></span>
												 </td> 
												 </tr>
                                                <tr> 
                                                <td>Middle</td>
												<td><input type="text" class="country" name="mname"></td>
												<td></td>
											</tr>
											
											<tr>
											<td>Last Name:<font class="red">*</font></td>
												<td><input type="text" class="country" name="lname" id="lname"/>
												</td>
												<td><span id="lnameInfo"></span></td>
												</tr>
                                            <tr>
												<td>Company</td>
												<td><input type="text" class="country" name="company" /></td>
												<td></td>
                                                </tr>
                                                <tr>
                                                <td>Address:<font class="red">*</font></td>
                                                
                                                 
												<td><input type="text" class="country" name="address" id="address"/>
												</td>
												<td><span id="addressinfo"></span></td>
                                                </tr>
                                                <tr>
												<td>City:<font class="red">*</font></td>
                                                
												<td><input type="text" class="country" name="city" id="city"/>
												</td>
												<td><span id="cityinfo"></span></td>
											</tr> 
                                                <tr><td>State:<font class="red">*</font></td>
												<td><select name="STATEPROVINCE" onChange="get1(this.value,<%=totalpricevalue %>);ChkSP();"
													class="country" id="country">

														<option value="ZZ">Choose state/Province</option>
														<% 
					ArrayList getallstate=(ArrayList)request.getAttribute("getallstate");
					if(!getallstate.isEmpty())
                        {  	
                        for(int i=0;i<getallstate.size();i++)
                         { 
                        	userDTO e=(userDTO)getallstate.get(i); 
                          %>
														<option value="<%=e.getState() %>"><%=e.getState() %></option>
														<%}} %>
												</select>
                                  <span id="countryinfo"></span>

													<div class="clear"></div>
													<p class="Canada">US and Canada Only!</p></td>
													<td><div class="WE-SHIP">
          	<strong> <div class="radio-button">
						<a onclick="window.open('shipping-cost.jsp?total=<%=totalpricevalue %>','popUpWindow','height=500,width=400,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');" href="#">
						 View Shipping Charges </a>
						
						
						
					 
					</div></strong>
            
             
          </div></td>
													
													</tr> 
													
													<tr>
													     <td colspan="2"> 
													     <div class="SHIPPING-METHOD">
          <strong style="float: left; display: inline-block; font-size: 13px;">SHIPPING VIA</strong>
          
         <div style="float: left;"> <div  class="couponcode">
 <img src="images/icon.PNG"  class="desins" /> 
<span class="coupontooltip" style="display: none;">
<div class="tooltip-arrow-left"></div>
<strong>WE SHIP MONDAY - FRIDAY</strong>

<p>Expected delivery days are estimated in business days and do not include weekends or holidays</p>

</span>
</div></div>
          
						 
          </div>
          <div class="clr"></div>
														  <div id="disp"> 
	      														
	                                                      </div>
	                                                      <span id="shipinfo"></span>
	                                                      
	                                                      
	                                                      
	                                                    </td>
                                                    </tr>
													
													<tr>
												<td>Subscribe to mailing list: </td>
												<td><input  type="checkbox" name="subcription"   checked="checked"/>
												</td>
											 
											</tr> 
											
											
											

											<tr>
 
												<td>Country</td>
												<td><select name="COUNTRY" class="country" id="shipcountry"
													onchange="chk1();get1('0',<%=totalpricevalue %>);">

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
                                                </tr>
                                                
                                                
                                                <tr>
												<td>Zip/Postal Code:<font class="red">*</font></td>
												<td><input type="text" class="country" name="postalcode" id="postalcode" />
												</td>
                                                <td><span id="postalcodeinfo"></span></td>
                                            </tr>
                                            
                                                    <tr>
												<td>Email:<font class="red">*</font></td>
												<td><input class="country" type="text" name="email" id="email" />
												</td>
												<td><span id="emailInfo"></span></td>
											</tr>
											 
                                                <tr>
												<td>Phone:<font class="red">*</font></td>
												<td><input type="text" class="country" name="phone" maxlength="10" id="phone"/>
												</td>
												<td><span id="phoneInfo"></span></td>
											</tr> 
											 <tr>
												<td colspan="2">
												<div class="buttond-blue1"><a href="indexpage">Continue to Shopping»</a></div>
													<div class="empty"></div>
												</td>
												
												<td > 
												<input type="submit" value="Continue"	class="buttond-blue" />
												</td>
											 
											</tr> 
											<tr> 
												<td  align="left"></td> 
												 
												<td></td>
												<td></td>
											</tr>
										</table> 
        	           </form>     
        	           
        	           	<script type="text/javascript" src="validation2.js"></script>
        	           
        	           
        	           
        	                
				        <%
						} else 
						{
						%> 
						
						
						
						<%} %>  
        	               	
							 <%}
							 else
							  {
							   for(int i=0;i<userdetails.size();i++)
                               { 
                        	    userDTO e=(userDTO)userdetails.get(i); 
                               %>
                               <!-- my task from here   -->
                               
                               <table>  
						                  <tr>
						                    <td>
						                       <font color="red">
														<%
														ArrayList el = (ArrayList) request.getAttribute("errorlistafterlogin");
														%>
														<%
														if (el != null) {
														Iterator it = el.iterator();
														while (it.hasNext()) {
														%>
														<%
														out.println(it.next());
														%>
														<br>
														<%
														}
														}
														%></font>
						                    </td>
						                  </tr> 
						                  </table>
                               
                               
								  <form name="checkoutform1" action="paymentgateway1" method="post" id="uservalidationafterlogin"> 
                                  <table>
						                  <tr>
												<td class="tablewidth">First Name:<font class="red">*</font></td>
												<td class="tablewidth1"><input type="text" class="country" value="<%=e.getFname() %>" name="fname" id="fname"></td>
												 <td class="tablewidth2">
												  <span id="fnameInfo"></span>
												 </td> 
												 </tr>
                                                <tr> 
                                                <td>Middle</td>
												<td><input type="text" class="country" value="<%=e.getMname() %>" name="mname"></td>
												<td></td>
											</tr>
											
											<tr>
											<td>Last Name:<font class="red">*</font></td>
												<td><input type="text" class="country" value="<%=e.getLname() %>" name="lname" id="lname"/></td>
												<td><span id="lnameInfo"></span></td>
												</tr>
                                            <tr>
												<td>Company</td>
												<td><input type="text" class="country" value="<%=e.getCompany() %>" name="company" /></td>
												<td></td>
                                                </tr>
                                                <tr>
                                                <td>Address:<font class="red">*</font></td>
                                                
                                                 
												<td><input type="text" class="country" value="<%=e.getAddress() %>" name="address" id="address"/></td>
												<td><span id="addressinfo"></span></td>
                                                </tr>
                                                <tr>
												<td>City:<font class="red">*</font></td>
                                                
												<td><input type="text" class="country" value="<%=e.getCity() %>" name="city" id="city"/></td>
												<td><span id="cityinfo"></span></td>
											</tr>
											
												 
												
                                                <tr><td>State:<font class="red">*</font></td>
												<td><select name="STATEPROVINCE1" onChange="get1(this.value,'<%=totalpricevalue %>');ChkSP1();"
													class="country" id="country">
														 
														<option value="<%=e.getState() %>"><%=e.getState() %></option>
														<option value="ZZ">Choose state/Province</option>
														<% 
					ArrayList getallstate=(ArrayList)request.getAttribute("getallstate");
					if(!getallstate.isEmpty())
                        {  	
                        for(int i1=0;i1<getallstate.size();i1++)
                         { 
                        	userDTO e1=(userDTO)getallstate.get(i1); 
                          %>
														<option value="<%=e1.getState() %>"><%=e1.getState() %></option>
														<%}} %>
												</select>
 <span id="countryinfo"></span>

													<div class="clear"></div>
													<p class="Canada">US and Canada Only!</p></td>
													
													</tr>
													
													<tr>
													     <td colspan="2"> 
													     
													     <div class="SHIPPING-METHOD">
          <strong style="float: left; display: inline-block; font-size: 13px;">SHIPPING VIA</strong>
          
         <div style="float: left;"> <div  class="couponcode">
 <img src="images/icon.PNG"  class="desins" /> 
<span class="coupontooltip" style="display: none;">
<div class="tooltip-arrow-left"></div>
<strong>WE SHIP MONDAY - FRIDAY</strong>

<p>Expected delivery days are estimated in business days and do not include weekends or holidays</p>

</span>
</div></div>
          
						 
          </div>
          <div class="clr"></div>
													     
													     
														  <div id="disp"> 
	      														
	                                                      </div>
	                                                      <span id="shipinfo"></span>
	                                                    </td>
                                                    </tr>
                                                    
                                                    
                                            <tr>
												<td>Subscribe to mailing list: </td>
												<td><input  type="checkbox" name="subcription"   checked="checked"/>
												</td>
											 
											</tr> 
											
                                                   

											<tr>

												<td>Country</td>
												<td><select name="COUNTRY1" class="country" id="shipcountry"
														onchange="chk11();get1('0',<%=totalpricevalue %>);getcalculatefinaltot1();">
 <option value="<%=e.getCountry() %>"><%=e.getCountry() %></option>
														<option value="">Choose country</option>
														<% 
					ArrayList getcountry=(ArrayList)request.getAttribute("getcountry");
					if(!getcountry.isEmpty())
                        {  	
                        for(int i2=0;i2<getcountry.size();i2++)
                         { 
                        	userDTO e2=(userDTO)getcountry.get(i2); 
                          %>
														<option value="<%=e2.getCountry() %>"><%=e2.getCountry() %></option>
														<%} }%>
												</select></td>
                                                </tr>
                                                
                                                
                                                <tr>
												<td>Zip/Postal Code:<font class="red">*</font></td>
												<td><input type="text" class="country" value="<%=e.getPostalcode() %>" name="postalcode" id="postalcode" maxlength="5"/></td>
                                                <td><span id="postalcodeinfo"></span></td>
                                                </tr>
												
												 <tr>
												<td>Email:<font class="red"></font></td>
												<td><input class="country" value="<%=e.getEmail() %>" type="text" name="email" id="email"/></td>
												<td><span id="emailInfo"></span></td>
											</tr>
												
                                                <tr>
												<td>Phone:<font class="red">*</font></td>
												<td><input type="text" class="country" value="<%=e.getPhone() %>" name="phone" id="phone"/></td>
												<td><span id="phoneInfo"></span></td>
											</tr> 
											 
											<tr> 
												<td colspan="2" align="left"><div class="buttond-blue1"><a href="indexpage">Continue to Shopping»</a></div></td> 
												 
												<td><input type="submit" value="Continue"	class="buttond-blue" /></td>
												
											</tr>	 
											 
										</table>
										
        	           </form>      
        	           
        	           <script type="text/javascript" src="uservalidation.js"></script>	
							 <%}} %> 
          
          
   
    
    <div class="clr1"></div>
        </div>
     </div>
     </div>
     <%@ page import="java.text.*" %> 
     
    <div class="col-md-2">
      <div class="summey">
      	<strong>SUMMARY</strong>
        <table width="100%" border="0">
  <tbody>
  
  <tr>
    <td colspan="2">
     <font color="red">
<%
ArrayList e3 = (ArrayList) request.getAttribute("error");
%>
<%
if (e3 != null) {
Iterator it = e3.iterator();
while (it.hasNext()) {
%>
<%
out.println(it.next());
%>
<br>
<%
}
}
%></font>

<%if(request.getAttribute("success")==null){ %>

<%} else { %>

<font color="green">
       <%=request.getAttribute("success") %> 
       </font>
<%} %>
     
    </td>
  </tr>
  
  
   
   

  
   
 	   
 	   
 	<tr>
    <td>MERCHANDISE TOTAL</td>
    <td id='ftot2' style="display: none;"> 
    </td>
     
    <td id="fitotf"><fmt:formatNumber currencySymbol="$" groupingUsed="FALSE" type="currency" value="<%=totalpricevalue%>"></fmt:formatNumber></td>
  </tr> 
    
   <tr >
       <td id="result" colspan="2">	
   </tr> 
    
    <tr>
	 <td>ORDER TOTAL</td>
 	<td>
		<div id='ftot'></div>
	</td>
	</tr>   
   
  </tbody>
  </table>
 
  
 <strong>Have a Coupon Code</strong>
 <!-- <font color="red"><div id="errormsg11"></div>
	  
	  
	 </font> -->
 <div class="coupon"></div>
 <div style="color: red;" id="errormsg11"></div>
 <form id="loginformd" name="loginformd" >
     <input type="hidden" name="finaltotal" id="couponvc" class="tet1" value="<%=session.getAttribute("totalpricevalue") %>">
	 <input type="text" name="coupancode" id="couponv" class="country3"><span id="addressinfo1"></span>
	 <input type="button" name="submit1" id="submit1" class="myButton" onclick="getCoupon(<%=totalpricevalue%>,0);" value="Apply">
 </form>
  <script type="text/javascript" src="coupon.js"></script>
 
 	
  
 <div class="clerar-bottom"></div>
<strong class="shop">SHOPPING BAG</strong>
 <div class="accordion">
			
			
			
	<c:forEach items="${carddetails}" var="c">
			<h3 id="dd${c.cartID}"> 
			
			<c:if test="${fn:length(c.product_name)>30}">
				<c:set var="string2" value="${fn:substring(c.product_name, 0, 28)}" />
				${string2} ...
				</c:if>
				<c:if test="${fn:length(c.product_name)<=30}">
				${c.product_name}
			</c:if> 
			
			</h3>
			<div id="d${c.cartID}">
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
  
  <c:if test="${c.colorandsize ne null}">
  <tr>
  	<td><p>&nbsp; </p></td>
    <td><p> ${c.colorandsize}</p></td>
  </tr>
  
  <tr>
  	<td><p>&nbsp; </p></td>
  	<td><p>&nbsp; </p></td><%-- href="deletecartitemsaftercheckout?cid=${c.cartID}&pid=${c.pid}"  deleteitem(${c.cartID},${c.price * c.qty},${c.qty}) --%>
    <td><p> <a onclick="deleteitem(${c.cartID},${c.price * c.qty},${c.qty})">Remove </a></p></td>
  </tr>
  <script type="text/javascript">
  
 
  function getcalculate1(aa,cpr)
  {   
	  b  = document.getElementById('fitotf').innerHTML;
	 // alert(aa+' '+b+' '+cpr);
	  try{
	  cpr = document.getElementById('couponprice').innerHTML; 
	  }catch (e) {
		 // alert("cp catch gc1()");
		cpr=0;
	}
	  
	  try{
	    var afterSplit = aa.split(',');
	    var a = afterSplit[0];
	  }catch(e){
		  
	  } 
	    var c =0;
	    var c2 =0;
	    if(a[0]=='$'){
	    	a=a.slice(1);
	    }else {
			a = a;
		}
	    if(b[0]=='$'){
	    	b = b.slice(1);
	    }else {
	    	b = b;
	    }
	    if(cpr[0]=='$'){
	    	cpr=cpr.slice(1);
	    }
	    //alert(a+"  "+b+"  "+cpr);
	   if(a=="")
	   {
		   c=b-cpr;
		  //alert('c1--->'+c)
		   document.getElementById('ftot').innerHTML="$"+c.toFixed(2);
		   document.getElementById('ftot2').innerHTML="$"+c.toFixed(2);
		exit;   
	   }
	   if(a=='null')
	   {
		   c=b-cpr;
		   //alert('c2--->'+c)
		   document.getElementById('ftot').innerHTML="$"+c.toFixed(2);
		   document.getElementById('ftot2').innerHTML="$"+c.toFixed(2);
		exit;   
	   }
	  
	  // alert("aaaaaaaa : "+a+" b : "+b);
	   var fintota = (parseFloat(b) + parseFloat(a));
	   
	   c = fintota-cpr;
	   c2 = fintota;
	   //alert(cpr+'c3--->'+fintota)
	   /* c=Math.round(c * 100) / 100;
	   c2=Math.round(c2 * 100) / 100; */
	   document.getElementById('ftot').innerHTML="$"+c.toFixed(2);
	   document.getElementById('ftot2').innerHTML="$"+c2;
  }
</script>

<script type="text/javascript">
  
 
  function getcalculate(aa,b,cpr)
  {   
	  //alert(aa+' '+b+' '+cpr);
	  try{
	  cpr = document.getElementById('couponprice').innerHTML; 
	  }catch (e) {
		 // alert("cp catch gc()");
		cpr=0;
	}
	  //alert(cpr);
	  try{
	    var afterSplit = aa.split(',');
	    var a = afterSplit[0];
	  }catch(e){
		  
	  } 
	    var c =0;
	    var c2 =0;
	    if(a[0]=='$'){
	    	a=a.slice(1);
	    }else {
			a = a;
		}
	    if(b[0]=='$'){
	    	b = b.slice(1);
	    }else {
	    	b = b;
	    }
	    if(cpr[0]=='$'){
	    	cpr=cpr.slice(1);
	    }
	   if(a=="")
	   {
		   c=b-cpr;
		 // alert('c1--->'+c);
		   document.getElementById('ftot').innerHTML="$"+c.toFixed(2);
		   document.getElementById('ftot2').innerHTML="$"+c.toFixed(2);
		exit;   
	   }
	   if(a=='null')
	   {
		   c=b-cpr;
		 // alert('c2--->'+c);
		   document.getElementById('ftot').innerHTML="$"+c.toFixed(2);
		   document.getElementById('ftot2').innerHTML="$"+c.toFixed(2);
		exit;   
	   }
	  
	   
	   var fintotal=parseFloat(a)+ parseFloat(b);
	   c = fintotal-cpr;
	   c2 = fintotal;
	  // alert(c);
	  // alert('c3--->'+c);
	   c=c.toFixed(2);
	   c2=c2.toFixed(2);
	   document.getElementById('ftot').innerHTML="$"+c;
	   document.getElementById('ftot2').innerHTML="$"+c2;
    }
</script>
  <script>
  function getCoupon(prodPrice,cancel){
		
		//getting total price and slicing it to remove $
		var totalPrice = document.getElementById('fitotf').innerHTML;
		if(totalPrice[0]=='$'){
			 
			totalPrice=totalPrice.slice(1);
	    }else {
	    	totalPrice = totalPrice;
		}
		
		
		//Shipcost value if defined or undefined for calculation
		//$('input[name=shipcost]:checked', '#customForm2').val()
		//$('#shipcosts').val();
		var shipCost = 0;
		shipCost1 = $('input[name=shipcost]:checked').val();
		//shipCost2 = $('input[name=shipcost]:checked', '#customForm2').val();
		couponv = $('#couponv').val();
		
		var allow = 0;
		if (typeof shipCost1 === "undefined") {
		shipCost=0;
		}
		else{
			
		  afterSplit= shipCost1.split(',');
		  shipCost = parseFloat(afterSplit[0]);
		  allow = 1;
		}
		/* if(allow = 0){
			if (typeof shipCost2 === "undefined") {
		 		shipCost=0;
		 	}
		 		else{
		 			
		 		  afterSplit= shipCost2.split(',');
		 		  shipCost = afterSplit[0];
		 		}
			}  */
		//alert(totalPrice+" "+prodPrice+" "+couponv+" "+shipCost);
		//checking for emptiness
		if(couponv.length<=0)
		{
		
			$("#errormsg11").html("<p>Enter Coupon Code</p>");
		}
		else
		{
			
			var totalPrice1 = parseFloat(totalPrice);
		  	
			$.ajax({  
			type: "POST",  
			url: "getCoupon.jsp",  
			data: {couponv : couponv, totalPrice : totalPrice, prodPrice : prodPrice}, 
			beforeSend: function() 
			{
				//$('#process').html("<p>Just Wait a Moment</p>");
			},  
			success: function(data)
			{
				 data=data.trim();
				$('#errormsg11').html("");
				if(data==1) 
				{
					$('#errormsg11').html("Purchase price is less than coupon code value");

				}
				else if(data==2){
					$('#errormsg11').html("Invalid Coupon code");
					
				}
				else{
					//alert(totalPrice+" hi "+shipCost);
			        data1 =parseFloat(data).toFixed(2);
			        
					finaltotal = parseFloat(totalPrice)+shipCost;
					finaltotal = finaltotal - data1;
					// alert(finaltotal);
					$('#result').html("<div style='float:left'>COUPON VALUE</div><div id='couponprice' style='float:right;margin-right: 26px;'>$"+data1+"</div>");
					$('#ftot').html("$"+parseFloat(finaltotal).toFixed(2));
					
					
				}
				 
				
				
			}
		});
			
		}//end of else
		 
		 
		
		
	}//end of coupon function
  
  function deleteitem(cartID,price,qty){
		price = price.toFixed(2);
		var totalPrice = document.getElementById('fitotf').innerHTML;
		//alert(cartID);
		
		var cartcount = document.getElementById('cartcount').innerHTML;
		//alert(cartcount);
		var shipCost = 0;
		shipCost1 = $('input[name=shipcost]:checked').val();
		//shipCost2 = $('input[name=shipcost]:checked', '#customForm2').val();
		var allow = 0;
		if (typeof shipCost1 === "undefined") {
	 		shipCost=0;
	 	}
	 		else{
	 			
	 		  afterSplit= shipCost1.split(',');
	 		  shipCost = afterSplit[0];
	 		  allow = 1;
	 		}
		/* if(allow = 0){
		if (typeof shipCost2 === "undefined") {
	 		shipCost=0;
	 	}
	 		else{
	 			
	 		  afterSplit= shipCost2.split(',');
	 		  shipCost = afterSplit[0];
	 		}
		} */
		//alert("shipCost : "+shipCost+"  "+price+"  "+qty);
		try{
		var couponv = document.getElementById('couponprice').innerHTML;
		}catch(e){
			couponv=0;
		}
		//var user = document.getElementById('user').value;
		
		//alert(couponv);
		
		if(couponv[0]=='$'){
			couponv=couponv.slice(1);
	    }else {
	    	couponv = couponv;
		}
		

		
		
		cartcount = cartcount - qty;
		
		if(totalPrice[0]=='$'){
			totalPrice=totalPrice.slice(1);
	    }else {
	    	totalPrice = totalPrice;
		}
		//alert("total before : "+totalPrice+ " price :"+price);
		totalPrice = totalPrice - price;
		
		
		var strURL = "deleteItem.jsp?cartID="+cartID;
		var req = getXMLHTTP();

		if (req) 
		{

			req.onreadystatechange = function() 
			{
				if (req.readyState == 4) 
				{
					// only if "OK"
					if (req.status == 200) 
					{
						
						if(totalPrice==0 ){
							window.location="viewcartdetails";
						}
						else{
						//alert("tp : "+totalPrice+" sc "+shipCost);
						finaltotal = totalPrice+parseFloat(shipCost);
						//alert(finaltotal+"copon"+couponv);
						finaltotal = finaltotal - couponv;
						
						
						
						$("#d"+cartID).slideUp();
						document.getElementById('d'+cartID).innerHTML = "";
						 
						$("#dd"+cartID).remove();
						document.getElementById('fitotf').innerHTML = "$"+totalPrice.toFixed(2);
						document.getElementById('cartcount').innerHTML = cartcount;
						document.getElementById('ftot').innerHTML = "$"+finaltotal.toFixed(2);
						
						}
						//getcalculate(shipCost,totalPrice,couponv);


					} else {
						// alert("There was a problem while using XMLHTTP:\n" +
						// req.statusText);
					}
				}
			}
			//document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
			// here
			// request
			req.open("GET", strURL, true);
			req.send();
		}

	}
  </script>
  
   </c:if>
             </tbody></table>

			</div>
	 </c:forEach>
		</div>
      </div>
   </div>
       <!-- deletecartitemsaftercheckout?cid=${c.cartID}&pid=${c.pid} -->
     
</div>

	<jsp:include page="zooming-f.jsp"></jsp:include>
</body>
</html>
