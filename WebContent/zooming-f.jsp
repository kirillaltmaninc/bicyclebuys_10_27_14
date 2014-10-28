<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 


</head>
<body>
 <div class="footer">
  <div class="footer-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="footer" style="padding:0;">
            <div class="footer-cols-wrapper">
              <div class="footer-col">
                <div class="f_block">
                  <h4>Information<span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1">
                      <ul>
                        <li><a href="indexpage">Home</a></li>
                        <li><a href="Shipping">Shipping</a></li>
                        <li><a href="Privacy-Policy">Privacy Policy</a></li>
                        <li><a href="store-info">Store Info </a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="footer-col">
                <div class="f_block">
                  <h4>Customer Service<span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1">
                      <ul>
                        <li><a href="viewcartdetails">View Cart </a></li> 
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
               
               
               
               
              <div class="footer-col wide-col">
                <div class="f_block">
                  <h4>Subscribe for Saving<span class="toggle"></span></h4>
                  <div class="footer-col-content">
                  <form action="subscribetoemail" method="post" >
                     <input type="text" id="newsEmail" name="emailid" value="Enter your email here" onfocus="this.value=''" onblur="if(this.value=='') this.value='Enter your email here';">
                     <input name="" type="submit" value=">" onclick="subscribe()" class="newsSubmit">
                      <div class="clear"></div>
                      <font color="red">
                     <div id="errormsg">
                     <%@ page import="java.util.*" %> 
                     <%if(request.getAttribute("errorforsubcription")==null) {%>
                     <%} else { %>
                         <%ArrayList el = (ArrayList) request.getAttribute("errorforsubcription");
                            %><%if (el != null) {Iterator it = el.iterator();while (it.hasNext()) {%><%out.println(it.next());%><br><%}}%>
                     <%} %></div>
                     </font>
                    </form>
                  </div>
                </div>
              </div>
              <div class="footer-col wide-col last" style="width:150px;">
                <div class="f_block block-subscribe">
                  <h4> <span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1"> <img src="images/brand.JPG" width="149" height="108">
                      <ul>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="contents">
        <p>Bicyclebuys.com will process any manufacturers warranty on any product we sell. Warranty claims need to be made to customer support at bicyclebuys.com. All warranty claims will be assessed based on the manufacturer's guidelines. Please call us at 1-888-4-Bike-Buy (1-888-424-5328, 631-673-2211) or e-mail your questions to info@bicyclebuys.com.</p>
      </div>
    </div>
  </div>
</div>
<div class="design-wrapper">
  <div class="container">
    <div class="design">
      <p class="fcl">BicycleBuys.com @ 2013 All rights reserved. </p>
      <p class="fcr">Phone: 1-888424-5328 1-631-673-2211 Email: info@bicyclebuys.com</p>
      <div class="clr"></div>
    </div>
  </div>
  <div class="clr"></div>
</div>
<div class="container"></div>

<!-- /container --> 

<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 
 


 
</script>
</body>
</html>
    