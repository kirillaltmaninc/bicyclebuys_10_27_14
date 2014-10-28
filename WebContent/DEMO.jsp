<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bycycle</title>
<link href="Bycycle.css" rel="stylesheet" type="text/css" media="screen">
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<script type="text/javascript">
function hideshow(which){
if (!document.getElementById)
return
if (which.style.display=="none")
which.style.display="block"
else
which.style.display="none"
}
</script>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>




 	<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script> 
 	<script language="javascript">

var xmlHttp;

function showfirstret(str,index)
{ 
xmlHttp=GetXmlHttpObject();
if (xmlHttp==null)
  {
  alert ("Your browser does not support AJAX!");
  return;
  }

var url="getRoleList.jsp?id="+str+"&index="+index+"";
 
xmlHttp.onreadystatechange=function()
{
	if (xmlHttp.readyState==4)
	{  
	  if(index=='countrydf')
			{
				document.getElementById("statedfd").innerHTML=xmlHttp.responseText;
			} 
	}
	
	}
xmlHttp.open("GET",url,true);
xmlHttp.send(null);
} 

function GetXmlHttpObject()
{
var xmlHttp=null;
try
  { 
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  { 
  try
    {
    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }
  catch (e)
    {
    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
return xmlHttp;
}
</script>

<script type="text/javascript">
$(document).ready(function(){ 
	load_options('','state');  
	load_options('','country');
});

function load_options(id,index){
	$("#loading").show();	
	$.ajax({
		url: "GetList.jsp?index="+index+"&id="+id,
		complete: function(){$("#loading").hide();},
		success: function(data) {
			$("#"+index).html(data);
		}
	})
}
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
  
  
</head>

<body>
<div class="main">
  <div class="tagline-wrapper">
    <div class="tagline">
      <h1>the Holiday gift Guide - Find the Right Gift For Any cyclist &gt;&gt;</h1>
    </div>
  </div>
  <div class="tagline1-wrapper">
    <div class="tagline1">
      <div class="checkout">
        <ul>
          <li>My Account</li>
          <li>(0) item(s) - $0.00</li>
          <li>Check out</li>
        </ul>
      </div>
      <div class="number"> <span>1.800.424.5328</span> </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="logo-wrapper"> </div>
</div>
<div class="test"> </div>
<div style="clear:both;"></div>
<div class="logo-inner">
      <div class="logo"><a href="indexpage"><img src="image/logo.PNG"  ></a></div>
       
      <div class="top-menu1">
        <div class="search">
          <input type="text" id="name" value="Search | Bike,Cloths &amp; more..." onfocus="this.value=''" onblur="if(this.value=='') this.value='Search | Bike,Cloths &amp; more...';" class="search1">
          <div class="botton"> <a href="#"> <img src="image/seacrch.png" width="12" height="15"> </a></div>
        </div>
      </div>
      <div class="clr"></div>
    </div>
<div class="clear"></div>
<div class="clients">
  <p><img src="images/border.JPG" width="959" height="7"> </p>
  <div class="login1">
    <h1>New customer</h1>
    <ul class="formlist">
    
    <table>
      <tr>
        <td>
         <%@ page import="java.util.*" %>
         <font color="red">
<%
ArrayList el = (ArrayList) request.getAttribute("error");
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

<%if(request.getAttribute("success")==null){ %>

<%} else { %>

<font color="green">
    <b>   <%=request.getAttribute("success") %></b> 
       </font>
<%} %>
        </td>
      </tr>
    </table>
    
    
     <%@page import="com.admin.action.*"%>
<% 

userDTO rBean = (userDTO) request.getAttribute("bean");
    %>
        	<%
if (request.getAttribute("error") == null) {
		%>
		
    <form name="checkoutform" action="registeruser" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>First Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="fname"></td>
          <td>Middle</td>
          <td><input type="text" class="tet" name="mname"></td>
        </tr>
        <tr>
          <td>Last Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="lname"></td>
          <td>Company</td>
          <td><input type="text" class="tet" name="company"></td>
        </tr>
        <tr>
          <td>Address:<font class="red">*</font></td>
          <td><textarea  class="tet"  rows="3" cols="20" name="address"></textarea></td>
          <td>City:<font class="red">*</font></td>
          <td><input type="text" class="tet"  name="city"/></td>
        </tr> 
       
        <tr>
          <td>Zip/Postal Code:<font class="red">*</font></td>
          <td><input   type="text"  class="tet" name="postalcode"/></td>
          <td>State:<font class="red">*</font></td>
          <td> 
           <select name="STATEPROVINCE"  onChange="ChkSP()" class="tet">

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
           
          
            <div style="clear:both;"></div>
            <p style="font-size:11px; margin:0; padding:0; font-weight:normal;"> US and Canada Only!</p></td>
        </tr>
        <tr>
          <td>Email:<font class="red">*</font></td>
          <td><input  class="tet" type="text"  name="email"/></td>
          <td>Country</td>
          <td><select name="COUNTRY"  class="tet" onchange="chk1()">

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
          <td colspan="2">Subscribe to mailing list
            <input type="checkbox" name="subscription"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>Phone:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="phone"></td>
          <td>Province</td>
          <td><input type="text" class="tet" name="Province" ></td> 
        </tr>
        <tr>
          <td>Fax</td>
          <td><input type="text" class="tet" name="fax"></td>
          <td>Comments</td>
          <td><textarea  class="tet"  rows="3" cols="20" name="comment"></textarea></td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td colspan="3" scope="col"><button name="login_submit" class="buttond blue" type="submit">Register</button></td>
        </tr>
      </table>      
      </form>
      
        <%
} else 
{
%>
<jsp:useBean id="bean" class="com.admin.action.userDTO"  
	scope="request"></jsp:useBean>
      <form name="checkoutform" action="registeruser" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>First Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="fname" value="${bean.fname}"></td>
          <td>Middle</td>
          <td><input type="text" class="tet" name="mname" value="${bean.mname}"></td>
        </tr>
        <tr>
          <td>Last Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="lname" value="${bean.lname}"></td>
          <td>Company</td>
          <td><input type="text" class="tet" name="company" value="${bean.company}"></td>
        </tr>
        <tr>
          <td>Address:<font class="red">*</font></td>
          <td><textarea  class="tet"  rows="3" cols="20" name="address">${bean.address}</textarea></td>
          <td>City:<font class="red">*</font></td>
          <td><input type="text" class="tet"  name="city" value="${bean.city}"/></td>
        </tr>
        <tr>
          <td>Zip/Postal Code:<font class="red">*</font></td>
          <td><input   type="text"  class="tet" name="postalcode" value="${bean.postalcode}"/></td>
          <td>State:<font class="red">*</font></td>
          <td> 
           <select name="STATEPROVINCE"  onChange="ChkSP()" class="tet">

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
          
            <div style="clear:both;"></div>
            <p style="font-size:11px; margin:0; padding:0; font-weight:normal;"> US and Canada Only!</p></td>
        </tr>
        <tr>
          <td>Email:<font class="red">*</font></td>
          <td><input  class="tet" type="text"  name="email" value="${bean.email}"/></td>
          <td>Country</td>
          <td><select name="COUNTRY"  class="tet" onchange="chk1()">

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
          <td colspan="2">Subscribe to mailing list
            <input type="checkbox" name="subscription"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>Phone:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="phone" value="${bean.phone}"></td>
          <td>Province</td>
          <td><input type="text" class="tet" name="Province" value="${been.Province}"></td>
        </tr>
        <tr>
          <td>Fax</td>
          <td><input type="text" class="tet" name="fax" value="${bean.fax}"></td>
          <td>Comments</td>
          <td><textarea  class="tet"  rows="3" cols="20" name="comment"></textarea></td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td colspan="3" scope="col"><button name="login_submit" class="buttond blue" type="submit">Register</button></td>
        </tr>
      </table>      
      </form>
      
      
      <%} %>
    </ul>
  </div>
  <div class="login">
    <h1>Existing user please sign in below</h1>
    <ul class="formlist">
    
    <table>
      <tr>
        <td>
          <font color="red">
<%
ArrayList e2 = (ArrayList) request.getAttribute("error1");
%>
<%
if (e2 != null) {
Iterator it = e2.iterator();
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
    
    <form action="loginuserg" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td scope="col"><span class="required">Email Address*</span></td>
          <td scope="col"><input type="text" name="useremail"  class="tet" /></td>
        </tr>
        <tr>
          <td scope="col"><span class=" required">Password</span></td>
          <td scope="col"><input type="password" class="tet" name="pwd"/></td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td scope="col"><button name="login_submit" class="buttond blue" type="submit">Log in</button>
            <a href="javascript:hideshow(document.getElementById('adiv1'))" style="padding:5px 0 0 0; display:block; color:#000; font-size:12px;">Forgot your password?</a></td>
        </tr>
      </table>      
      </form>
      <div id="adiv1" style="font:24px bold; display: none">
        <h1>Reset your password</h1>
        <table width="0" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td scope="col"><span class="required">Email Address*</span></td>
            <td scope="col"><input type="text" name="login-username"  class="tet" /></td>
          </tr>
          
            <td scope="col">&nbsp;</td>
            <td scope="col"><button name="login_submit" class="buttond blue" type="submit">Reset</button></td>
          </tr>
        </table>
      </div>
    </ul>
  </div>
  <div style="clear:both;"></div>
</div>
</div>
<div id="footer-wrapper">
  <div id="footer">
    <div class="part">
      <h1>Information</h1>
      <ul>
        <li><a href="#">About us</a></li>
        <li><a href="#">Delivery Information</a></li>
        <li><a href="#">Privacy Policy</a></li>
        <li><a href="#">Terms &amp; Conditions</a></li>
      </ul>
    </div>
    <div class="part">
      <h1>Customer Service</h1>
      <ul>
        <li><a href="#">Contact us</a></li>
        <li><a href="#">Returns</a></li>
        <li><a href="#">Site Map</a></li>
      </ul>
    </div>
    <div class="part">
      <h1>Extra</h1>
      <ul>
        <li><a href="#">Brands</a></li>
        <li><a href="#">Gift Vouchers</a></li>
        <li><a href="#">Affiliates</a></li>
        <li><a href="#">Specials</a></li>
      </ul>
    </div>
    <div class="part">
      <h1>My Accounts</h1>
      <ul>
        <li><a href="#">My Accounts</a></li>
        <li><a href="#">Order History</a></li>
        <li><a href="#">Wish List</a></li>
        <li><a href="#">NewsLetter</a></li>
      </ul>
    </div>
    <div class="part"> <img src="images/brand.JPG"  > </div>
    <div class="clr"></div>
    <p>Bicyclebuys.com will process any manufacturers warranty on any product we sell. Warranty claims need to be made to customer support at bicyclebuys.com. All warranty claims will be assessed based on the manufacturer's guidelines. Please call us at 1-888-4-Bike-Buy (1-888-424-5328, 631-673-2211) or e-mail your questions to info@bicyclebuys.com.</p>
  </div>
  <div class="clr"></div>
</div>
<div class="design-wrapper">
  <div class="design">
    <p class="fcl">BicycleBuys.com @ 2013 All rights reserved. </p>
    <p class="fcr">Phone: 1-888424-5328 1-631-673-2211 Email: info@bicyclebuys.com</a></p>
  </div>
  <div class="clr"></div>
</div>
</body>
</html>
