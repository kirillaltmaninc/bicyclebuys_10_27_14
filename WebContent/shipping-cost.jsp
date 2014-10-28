<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<!doctype html>
 
<html>
<head>
<title>bicyclebuys.com</title>
<script type="text/javascript" src="js/ajax.js"></script>
 
<link href="Bycycle.css" rel="stylesheet" type="text/css" media="screen">
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<script language="JavaScript" TYPE="text/javascript">




<!-- hide this script from non-javascript-enabled browsers

 

/* Function that swaps images. */

function di20(id, newSrc) {
    var theImage = FWFindImage(document, id, 0);
    if (theImage) {
        theImage.src = newSrc;
    }
}

/* Functions that track and set toggle group button states. */

function FWFindImage(doc, name, j) {
    var theImage = false;
    if (doc.images) {
        theImage = doc.images[name];
    }
    if (theImage) {
        return theImage;
    }
    if (doc.layers) {
        for (j = 0; j < doc.layers.length; j++) {
            theImage = FWFindImage(doc.layers[j].document, name, 0);
            if (theImage) {
                return (theImage);
            }
        }
    }
    return (false);
}

/* Function to automatically go to a new page when picking from a dropdown list */
function load1(form, win) {
  // vendorid - a reference to the select object
  // win - a reference to the window object
  win.location.href = form.vendorid.options[form.vendorid.selectedIndex].value
}

function load2(form, win) {
	// menu - a reference to the select object
	// win - a reference to the window object
	win.location.href = form.SHIPTYPE.options[form.SHIPTYPE.selectedIndex].value
}

function load3(form, win) {
	// menu - a reference to the select object
	// win - a reference to the window object
	win.location.href = form.SHIPSTATEPROVINCE.options[form.SHIPSTATEPROVINCE.selectedIndex].value
}

function load4(form, win) {
	// menu - a reference to the select object
	// win - a reference to the window object
	win.location.href = form.SHIPCOUNTRY.options[form.SHIPCOUNTRY.selectedIndex].value
}

function openpopwin(windowpage, popupwidth, popupheight) {
	window.open(windowpage, '', 'width=' + popupwidth + ',height=' + popupheight +
	',location=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes');
}

function openpopwin1(windowpage, popupwidth, popupheight) {
	window.open(windowpage, '', 'width=' + popupwidth + ',height=' + popupheight +
	',location=no,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes');
}

// stop hiding -->
</script>


<script type="text/javascript">
function ChkSP()
{
	  
if (document.checkoutform.stateabbr.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform.ShipCountry.value != "US")
{
document.checkoutform.ShipCountry.value = "US";
document.checkoutform.CUSTOM1.disabled=true;
document.checkoutform.CUSTOM1.value = 'for International';
}
}
} //end of function

 
function chk1()
{

	document.getElementById('disp').innerHTML="";
if (document.checkoutform.stateabbr.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutform.ShipCountry.value != "US")
{
 document.checkoutform.stateabbr.value = "ZZ"; 
}
}
}

</script>

<meta http-equiv="Content-Type"
content="text/html; charset=iso-8859-1">
<meta name="GENERATOR" content="Microsoft Notepad">
</head>

<body bgcolor="#E5E5F0" text="#000000" link="#3770A8" vlink="#3770A8" alink="#FFFFFF"
    topmargin="0" marginheight="0" leftmargin="0" marginwidth="0">
<div class="privacy">
  <center>
    <IMG SRC="image/logo.PNG" alt="Free Shipping* on orders over $99."> <a href="#" onclick="window.opener=null; window.close(); return false;"> <img src="images/close.png" width="36" height="36" border="0"></a>
  </center>
  <center>
    <IMG SRC="images/freeship150.gif" alt="Free Shipping* on orders over $99.">
  </center>
  <h1>View Shipping Charges </h1>
  <div class="shipping-center" style="width:100%; float: none;">
    <p><span style="font-size:16px;"> Choose shipping location to view the cost of our delivery options</span></p>
    <div style="clear:both;"></div>
    <div> 
    
    <form name="checkoutform">
      <table width="0" border="0">
        <tr>
          <td>U.S. State </td>
          <td><select style="width:100%;" name="stateabbr" onchange="get(this.value,<%=request.getParameter("total") %>),ChkSP()">
             
              <option value="">Select State</option>
              <%
              	ArrayList allStates = obj.getgetallstate();
                ArrayList getcountry = obj.getgetcountry();
              	pageContext.setAttribute("allStates", allStates);
              	pageContext.setAttribute("allCountry", getcountry);
              %>
              <option value="ZZ">Choose state/Province</option>
              <c:forEach var="dto" items="${allStates}">
              	<option value="${dto.state}">${dto.state}</option>
              </c:forEach>
              
            </select> <div id="loading"></div></td>
        </tr>
        <tr>
          <td colspan="2">Or</td>
        </tr>
        <tr>
          <td>&nbsp;Country</td>
          <td>
          
          <select name="ShipCountry" class="country" id="shipcountry" onchange="chk1()"> 
														<option value="">Choose country</option>
														<c:forEach var="dto" items="${allCountry}">
														<option value="${dto.country}">${dto.country}</option>
														</c:forEach> 
												</select>
          
           </td>
        </tr>
      </table>
      </form>
      <p><span style="font-size:16px;"> International Shipping</span></p>
      
      
      
      <p>A member of the BicycleBuys.com staff will contact you after your order is submitted.</p>
      
      
      
      <div id="disp">
      <table width="0" border="0">
        <tr>
          <td colspan="5">The table below contains approximate shipping costs, in US dollars,based on previous shipments to your country.</td>
        </tr>
      </table>
      </div>
      
      
      <p style="font-weight:bold;">At checkout the shipping method can be decided. We try our best to ship all orders within 48 hours of receiving. In the event that an item is not shippable within 4 days of date of order, you will be contacted.</p>
    </div>
  </div>
  <div style="clear:both;"></div>
</div>
<center>
</center>
</body>
</html>
